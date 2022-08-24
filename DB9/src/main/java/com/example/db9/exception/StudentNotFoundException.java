package com.example.db9.exception;

public class StudentNotFoundException extends Exception {

    private String message;

    public StudentNotFoundException(String message) {
        this.message = message;
    }

    public String toString() {
        return ("StudentNotFoundException Occured: " + message);
    }
}
