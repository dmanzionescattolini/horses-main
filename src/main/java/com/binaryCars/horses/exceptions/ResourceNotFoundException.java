package com.binaryCars.horses.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Long id){
        super("No car found with id "+ id);
    }
}
