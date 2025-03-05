package com.example.cms.controller.exceptions;

public class TequilaNotFoundException extends RuntimeException{
    public TequilaNotFoundException(Long id) {
        super("Could not find professor " + id);
    }
}
