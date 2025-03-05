package com.example.cms.controller.exceptions;

public class WineNotFoundException extends RuntimeException {
    public WineNotFoundException(Long id) {
        super("Could not find wine with ID: " + id);
    }
}