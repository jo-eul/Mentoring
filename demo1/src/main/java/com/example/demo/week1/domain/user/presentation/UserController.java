package com.example.demo.week1.domain.user.presentation;

import com.example.demo.week1.domain.user.presentation.dto.SignUpRequest;
import com.example.demo.week1.domain.user.presentation.dto.UserSignInRequest;
import com.example.demo.week1.domain.user.service.UserSignInService;
import com.example.demo.week1.domain.user.service.UserSignUpService;
import com.example.demo.week1.global.security.jwt.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserSignUpService userSignUpService;
    private final UserSignInService userSignInService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signup(@RequestBody SignUpRequest request){
        userSignUpService.signUp(request);
    }

    @PostMapping("/signIn")
    public TokenResponse signIn(@RequestBody UserSignInRequest request){
        return userSignInService.signIn(request);
    }
}
