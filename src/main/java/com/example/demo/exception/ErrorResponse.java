package com.example.demo.exception;

import lombok.Getter;

@Getter
public class ErrorResponse {

    private final int errorCode;
    private final String message;
    private final Object details;

    public ErrorResponse(int errorCode, String message, Object details) {
        this.errorCode = errorCode;
        this.message = message;
        this.details = details;
    }
}
