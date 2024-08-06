package com.example.demo.week1.global.error.exception;

import com.example.demo.week1.global.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{
    private ErrorCode errorCode;
}
