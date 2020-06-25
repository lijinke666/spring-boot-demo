package com.example.demo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

// 业务相关的异常
// Runtime的异常会进行事务回滚

@Getter
public class BaseException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final int errorCode;
    private final Object details;

    public BaseException(HttpStatus httpStatus, int errorCode, String message, Object details) {
        super(message);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.details = details;
    }

    public BaseException(HttpStatus httpStatus, int errorCode, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.details = null;
    }
}
