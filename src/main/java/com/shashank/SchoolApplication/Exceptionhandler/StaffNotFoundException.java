package com.shashank.SchoolApplication.Exceptionhandler;

public class StaffNotFoundException extends RuntimeException {
    public StaffNotFoundException(String message) {
        super(message);
    }
}
