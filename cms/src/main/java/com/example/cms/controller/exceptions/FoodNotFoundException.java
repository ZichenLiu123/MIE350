package com.example.cms.controller.exceptions;

public class FoodNotFoundException extends RuntimeException{
    public FoodNotFoundException(Long Id) {
        super("Could not find Food with ID: " + Id);
    }
}
