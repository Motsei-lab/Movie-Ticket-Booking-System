package com.mecerintered.movie.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String mess){
        super(mess);
    }
}
