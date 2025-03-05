package com.example.cms.controller.exceptions;

public class RumNotFoundException extends RuntimeException{
    public RumNotFoundException(Long id) {
        super("Could not find professor " + id);
    }
}
