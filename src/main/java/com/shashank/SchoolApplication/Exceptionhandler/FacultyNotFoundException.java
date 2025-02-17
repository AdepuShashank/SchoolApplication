package com.shashank.SchoolApplication.Exceptionhandler;

public class FacultyNotFoundException extends RuntimeException {
    public FacultyNotFoundException(String message) {
        super(message);
    }
}
