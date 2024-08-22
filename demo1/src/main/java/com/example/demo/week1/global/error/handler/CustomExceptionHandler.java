package com.example.demo.week1.global.error.handler;

import com.example.demo.week1.global.entity.ErrorResponseEntity;
import com.example.demo.week1.global.error.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ErrorResponseEntity> handleCustomException(CustomException customException){

        return ErrorResponseEntity.responseEntity(customException.getErrorCode());
    }
}
