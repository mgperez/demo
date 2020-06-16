package com.example.demo.exception;

public class NotFoundException extends RuntimeException {
    private final int code;
    private final String description;

    public NotFoundException(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
