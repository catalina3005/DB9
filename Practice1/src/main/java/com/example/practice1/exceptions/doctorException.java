package com.example.practice1.exceptions;
public class doctorException extends Exception{
    public doctorException(){
        super("This doctor doesn't exist!");
    }
}