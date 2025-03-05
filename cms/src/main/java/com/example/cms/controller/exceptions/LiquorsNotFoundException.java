package com.example.cms.controller.exceptions;

public class LiquorsNotFoundException extends RuntimeException {
    public LiquorsNotFoundException(Long id) {
        super("Could not find liquor with ID: " + id);
    }
}