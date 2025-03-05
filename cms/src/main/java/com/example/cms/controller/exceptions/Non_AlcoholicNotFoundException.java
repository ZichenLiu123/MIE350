package com.example.cms.controller.exceptions;

public class Non_AlcoholicNotFoundException extends RuntimeException {
    public Non_AlcoholicNotFoundException(Long id) {
        super("Could not find Non Alcoholic beverage with ID: " + id);
    }
}