package com.example.demo.week1.domain.user.facade;

import com.example.demo.week1.domain.user.entity.User;
import com.example.demo.week1.domain.user.exception.UserNotFoundException;
import com.example.demo.week1.domain.user.entity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserRepository userRepository;

    public User getUserByUserName(String userName){
        return userRepository.findByName(userName).orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }
    
    public User getCurrentUser(){
        return getUserByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
    }
    
    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->UserNotFoundException.EXCEPTION);
    }
}
