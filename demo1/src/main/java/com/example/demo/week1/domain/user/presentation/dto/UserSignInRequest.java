package com.example.demo.week1.domain.user.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSignInRequest {
    private String name;
    private String password;

    public UserSignInRequest(UserSignInRequest request){
        this.name=request.getName();
        this.password=request.getPassword();
    }
}
