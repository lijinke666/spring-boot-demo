package com.example.demo.exception;

import com.example.demo.common.ErrorCode;
import com.example.demo.controller.ExceptionController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

// @ControllerAdvice 声明全局处理 assignableTypes 指定只处理特定的类
// @ControllerAdvice(assignableTypes = {ExceptionController.class})

@ControllerAdvice
@Slf4j
public class GlobalErrorHandler {

    // 捕获所有异常
//    @ExceptionHandler(value = Exception.class)
//    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e) {
//        if(e instanceof IllegalAccessException) {
//            // 用ErrorResponse包裹下, 只返回需要的信息
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(new IllegalAccessException("参数错误")));
//        }
//
//        if(e instanceof ResourceNotFoundException) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(new ResourceNotFoundException("未找到对应资源")));
//        }
//
//        return null;
//    }

    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<ErrorResponse> baseExceptionHandler(BaseException e) {
        log.error("@@@ {}", "22", e);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.CUSTOM_ERROR, e.getMessage(), e.getDetails());
        return ResponseEntity.status(e.getHttpStatus()).body(errorResponse);
    }
}
