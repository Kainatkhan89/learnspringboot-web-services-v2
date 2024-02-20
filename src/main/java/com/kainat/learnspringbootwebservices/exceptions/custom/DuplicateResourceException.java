package com.kainat.learnspringbootwebservices.exceptions.custom;

public class DuplicateResourceException extends RuntimeException{
    public DuplicateResourceException(String message){
        super(message);
    }
}
