package com.bismdhr.bankmgmtsystem.exception;

public class NotFoundException extends RuntimeException{
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public NotFoundException(String message) {
        super(message); //runtime exception
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
