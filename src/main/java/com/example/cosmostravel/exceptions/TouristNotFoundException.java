package com.example.cosmostravel.exceptions;

public class TouristNotFoundException extends RuntimeException {

    public TouristNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
