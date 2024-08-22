package com.example.demo.week1.domain.user.exception;

import com.example.demo.week1.global.error.ErrorCode;
import com.example.demo.week1.global.error.exception.CustomException;

public class UserNotFoundException extends CustomException {
    public final static CustomException EXCEPTION=new UserNotFoundException();
    private UserNotFoundException(){
        super(ErrorCode.USER_NOT_FOUND);
    }
}
