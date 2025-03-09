package com.example.cms.controller.exceptions;

public class AlcoholNotFoundException extends RuntimeException{
    public AlcoholNotFoundException(Long alcoholId) {
        super("Could not find Alcohol: " + alcoholId);
    }
}
