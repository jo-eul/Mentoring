package com.example.demo.week1.domain.user.Controller;

import com.example.demo.week1.domain.user.dto.SignUpRequest;
import com.example.demo.week1.domain.user.service.UserSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserSignUpService userSignUpService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signup(@RequestBody SignUpRequest request){
        userSignUpService.signUp(request);
    }
}
