package com.example.demo.week1.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_ALREADY_EXISTS(409, "name Already Exists"),
    USER_NOT_FOUND(404,"User Not Found" ),
    PASSWORD_MISMATCH(401, "Password Mismatch"),


    EXPIRED_TOKEN(401, "Expired Token"),
    INVALID_TOKEN(401,"Invalid Token.");



    private final Integer httpStatus;
    private final String message;
}
