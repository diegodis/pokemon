package com.pockemon.exceptions;

public class ErrorMessage {
    private String error;
    private String description;

    public ErrorMessage(Exception exception, String error) {
        this.error = error;
        this.description = exception.getMessage();
    }
}
