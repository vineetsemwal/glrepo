package com.gltrainings.securedemo.controllers;

import com.gltrainings.securedemo.dto.LoginRequest;
import com.gltrainings.securedemo.service.IUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    private IUserService service;
    public AppController(IUserService service){
        this.service=service;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
        return  service.login(loginRequest);
    }
}
