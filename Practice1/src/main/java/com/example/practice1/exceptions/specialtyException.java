package com.example.practice1.exceptions;

public class specialtyException extends Exception{
    public specialtyException(){
        super("This specialty doesn't exist!");
    }
}