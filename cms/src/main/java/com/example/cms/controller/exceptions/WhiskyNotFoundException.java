package com.example.cms.controller.exceptions;

public class WhiskyNotFoundException extends RuntimeException{
    public WhiskyNotFoundException(Long alcoholId) {
        super("Could not find Whisky: " + alcoholId);
    }
}
