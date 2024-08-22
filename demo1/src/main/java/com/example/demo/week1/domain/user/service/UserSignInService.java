package com.example.demo.week1.domain.user.service;

import com.example.demo.week1.domain.user.presentation.dto.UserSignInRequest;
import com.example.demo.week1.domain.user.entity.User;
import com.example.demo.week1.domain.user.exception.PasswordMismatchException;
import com.example.demo.week1.domain.user.exception.UserNotFoundException;
import com.example.demo.week1.domain.user.entity.repository.UserRepository;
import com.example.demo.week1.global.security.jwt.JwtTokenProvider;
import com.example.demo.week1.global.security.jwt.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSignInService {
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public TokenResponse signIn(UserSignInRequest request){
        User user=userRepository.findByName(request.getName()).orElseThrow(()-> UserNotFoundException.EXCEPTION);

        if(passwordEncoder.matches(user.getPassword(),request.getPassword())){
            throw PasswordMismatchException.EXCEPTION;
        }
        return jwtTokenProvider.generateToken(request.getName(),user.getRole().toString());
    }
}
