package com.kainat.learnspringbootwebservices.api.exceptions.custom;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message){
        super(message);
    }
}
