package com.example.demo.week1.domain.user.exception;

import com.example.demo.week1.global.error.ErrorCode;
import com.example.demo.week1.global.error.exception.CustomException;

public class UserAlreadyExitsException extends CustomException {

    public static final CustomException EXCEPTION=new UserAlreadyExitsException();

    private UserAlreadyExitsException(){
        super(ErrorCode.USER_ALREADY_EXISTS);
    }
}
