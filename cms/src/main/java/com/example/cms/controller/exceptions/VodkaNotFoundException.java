package com.example.cms.controller.exceptions;

public class VodkaNotFoundException extends RuntimeException {
    public VodkaNotFoundException(Long id) {
        super("Could not find Vodka with ID: " + id);
    }
}