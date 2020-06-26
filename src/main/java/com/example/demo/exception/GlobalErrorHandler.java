package com.example.demo.exception;

import com.example.demo.common.ErrorCode;
import com.example.demo.controller.ExceptionController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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

    // 捕获自定义业务异常
    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<ErrorResponse> baseExceptionHandler(BaseException e) {
        log.error("BaseException {}", "->", e);
        return this.getResponseEntity(e.getHttpStatus(), ErrorCode.BASE_EXCEPTION, e.getMessage(), e.getDetails());
    }

    // 捕获参数错误
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException {}", "->" , e);
        // 将哪些参数错了 组成 key value 的形式 告诉前端
        Map<String, String> errorDetails = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorDetails.put(fieldName, errorMessage);
        });
        return this.getResponseEntity(HttpStatus.BAD_REQUEST, ErrorCode.METHOD_ARGUMENT_NOT_VALID, "参数错误", errorDetails);
    }

    private ResponseEntity<ErrorResponse> getResponseEntity(HttpStatus httpStatus, int errorCode, String message, Object details) {
        ErrorResponse errorResponse = new ErrorResponse(errorCode, message, details);
        return ResponseEntity.status(httpStatus).body(errorResponse);
    }
}
