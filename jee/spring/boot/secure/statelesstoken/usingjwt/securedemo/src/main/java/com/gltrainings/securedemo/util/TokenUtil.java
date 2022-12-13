package com.gltrainings.securedemo.util;

import com.gltrainings.securedemo.exceptions.InvalidTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;

@Component
public class TokenUtil {
    private  final Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public String encode(String username, Set<String> roles) {
        long currentMillis=System.currentTimeMillis();
        long expiryMillis=currentMillis+(60*60*1000*24);
        Date expiryDate=new Date(expiryMillis);
        String token= Jwts.builder()
                .signWith(KEY)
                .setSubject(username)
                .setExpiration(expiryDate)
                .compact();
        return token;
    }

    public String decode(String token) {
        if (token.isBlank()) {
            throw new InvalidTokenException("token s not valid");
        }
        Jws<Claims> claimsHolder =Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token);
        Claims claims=claimsHolder.getBody();
        String username= claims.getSubject();
        return username;

    }


}
