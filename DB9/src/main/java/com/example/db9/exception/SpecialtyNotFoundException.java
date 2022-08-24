package com.example.db9.exception;

public class SpecialtyNotFoundException extends Exception {

    private String message;

    public SpecialtyNotFoundException(String message) {
        this.message = message;
    }

    public String toString() {
        return ("SpecialtyNotFoundException Occured: " + message);
    }
}