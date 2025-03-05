package com.example.cms.controller.exceptions;

public class BeerNotFoundException extends RuntimeException{
    public BeerNotFoundException(Long alcoholId) {
        super("Could not find Beer: " + alcoholId);
    }
}
