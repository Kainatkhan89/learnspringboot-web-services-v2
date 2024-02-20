package com.kainat.learnspringbootwebservices.api.exceptions.custom;

public class DuplicateResourceException extends RuntimeException{
    public DuplicateResourceException(String message){
        super(message);
    }
}
