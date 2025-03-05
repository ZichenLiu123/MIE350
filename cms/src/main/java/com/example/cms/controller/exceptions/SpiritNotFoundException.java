package com.example.cms.controller.exceptions;

public class SpiritNotFoundException extends RuntimeException {
    public SpiritNotFoundException(Long id) {
        super("Could not find Spririt with ID: " + id);
    }
}