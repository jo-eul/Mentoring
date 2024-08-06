package com.example.demo.week1.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_ALREADY_EXISTS(409, "name Already Exists");

    private final Integer httpStatus;
    private final String message;
}
