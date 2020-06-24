package com.example.demo.exception;

import com.example.demo.controller.ExceptionController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

// @ControllerAdvice 声明全局处理 assignableTypes 指定只处理特定的类

@ControllerAdvice(assignableTypes = {ExceptionController.class})
@ResponseBody
public class GlobalErrorHandler {

    // 捕获所有异常
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e) {
        if(e instanceof IllegalAccessException) {
            // 用ErrorResponse包裹下, 只返回需要的信息
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(new IllegalAccessException("参数错误")));
        }

        if(e instanceof ResourceNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(new ResourceNotFoundException("未找到对应资源")));
        }

        return null;
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> baseExceptionHandler(BaseException e) {
//        return ResponseEntity.status(e.getHttpStatus()).body();
        // TODO: 拿不到 code 和 details
        int errorCode = 1234;
        String errorMessage = e.getMessage();
        Object details = new HashMap<>();
        return ResponseEntity.status(400).body(new ErrorResponse(errorCode, errorMessage, details));
    }
}
