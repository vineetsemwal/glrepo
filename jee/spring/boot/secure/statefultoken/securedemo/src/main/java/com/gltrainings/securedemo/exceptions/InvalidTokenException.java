package com.gltrainings.securedemo.exceptions;

public class InvalidTokenException extends RuntimeException{

    public InvalidTokenException(String msg){
        super(msg);
    }

}
