package com.example.cms.controller.exceptions;

public class BrandyNotFoundException extends RuntimeException {
    public BrandyNotFoundException(Long id) {
        super("Could not find Brandy with ID: " + id);
    }
}