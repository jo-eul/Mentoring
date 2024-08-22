package com.example.demo.week1.domain.user.exception;

import com.example.demo.week1.global.error.ErrorCode;
import com.example.demo.week1.global.error.exception.CustomException;

public class PasswordMismatchException extends CustomException {
    public static final CustomException EXCEPTION=new PasswordMismatchException();

    private PasswordMismatchException(){
        super(ErrorCode.PASSWORD_MISMATCH);
    }

}
