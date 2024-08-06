package com.example.demo.week1.domain.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
public class SignUpRequest {
    private String name;

    private String password;
}
