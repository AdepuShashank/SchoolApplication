package com.shashank.SchoolApplication.Exceptionhandler;

public class StandardNotFoundException extends RuntimeException {
    public StandardNotFoundException(String message) {
        super(message);
    }
}
