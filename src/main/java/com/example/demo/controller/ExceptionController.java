package com.example.demo.controller;

import com.example.demo.common.ErrorCode;
import com.example.demo.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @GetMapping("/illegalAccessException")
    public void throwException1() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    @GetMapping("/responseStatusException")
    public void throwException3() throws ResponseStatusException {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "自定义错误消息", new IllegalAccessException());
    }

    @GetMapping("/baseException")
    public void throwException4() {
        throw new BaseException(HttpStatus.BAD_REQUEST, ErrorCode.CUSTOM_ERROR, "今天没吃饭");
    }

    @GetMapping("/baseException/details")
    public void throwException5() {
        Map<String, Integer> details = new HashMap<>();
        details.put("a", 1);
        throw new BaseException(HttpStatus.BAD_REQUEST, ErrorCode.TEST_ERROR, "我吃了饭", details);
    }
}
