package com.example.demo.week1.global.exception;

import com.example.demo.week1.global.error.ErrorCode;
import com.example.demo.week1.global.error.exception.CustomException;

public class InvalidTokenException extends CustomException {
    public static final CustomException EXCEPTION=new InvalidTokenException();

    private InvalidTokenException(){
        super(ErrorCode.INVALID_TOKEN);
    }
}
