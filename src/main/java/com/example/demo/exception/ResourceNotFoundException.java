package com.example.demo.exception;

import lombok.Getter;
import lombok.Setter;

// 自定义一个异常, 继承 RuntimeException
@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
    private String message;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
