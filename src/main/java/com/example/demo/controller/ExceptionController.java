package com.example.demo.controller;

import com.example.demo.exception.BaseException;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @GetMapping("/illegalAccessException")
    public void throwException1() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    @GetMapping("/resourceNotFoundException")
    public void throwException2() throws ResourceNotFoundException {
        throw new ResourceNotFoundException();
    }

    @GetMapping("/responseStatusException")
    public void throwException3() throws ResponseStatusException {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "自定义错误消息", new ResourceNotFoundException());
    }

    @GetMapping("/baseException")
    public void throwException4() throws BaseException {
        final int errorCode = 444;
        throw new BaseException(HttpStatus.BAD_REQUEST, errorCode, "今天没吃饭");
    }
}
