package com.example.cms.controller.exceptions;

public class PairingNotFoundException extends RuntimeException{
    public PairingNotFoundException(Long id) {
        super("Could not find Pairing with Id: " + id);
    }
}
