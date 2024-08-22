package com.example.demo.week1.global.exception;

import com.example.demo.week1.global.error.ErrorCode;
import com.example.demo.week1.global.error.exception.CustomException;

public class ExpiredTokenException extends CustomException{
    public static final CustomException EXCEPTION= new ExpiredTokenException();

    public ExpiredTokenException(){
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
