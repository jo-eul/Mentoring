package com.example.demo.week1.domain.user.service;

import com.example.demo.week1.domain.user.dto.SignUpRequest;
import com.example.demo.week1.domain.user.entity.User;
import com.example.demo.week1.domain.user.exception.UserAlreadyExitsException;
import com.example.demo.week1.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserSignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(SignUpRequest signUpRequest){
        Boolean checkAlreadyName = userRepository.existsByName(signUpRequest.getName());

        if(!checkAlreadyName) {
            User user = User.builder()
                    .name(signUpRequest.getName())
                    .password(passwordEncoder.encode(signUpRequest.getPassword()))
                    .build();

            userRepository.save(user);
        }
        else{
            throw UserAlreadyExitsException.EXCEPTION;
        }

    }
}
