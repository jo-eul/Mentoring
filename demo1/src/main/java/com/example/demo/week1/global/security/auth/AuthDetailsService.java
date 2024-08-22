package com.example.demo.week1.global.security.auth;

import com.example.demo.week1.domain.user.entity.User;
import com.example.demo.week1.domain.user.exception.UserNotFoundException;
import com.example.demo.week1.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {
    public final UserFacade userFacade;

    @Override
    public AuthDetails loadUserByUsername(String name) throws UserNotFoundException{
        User user=userFacade.getUserByUserName(name);
        return new AuthDetails(user);
    }
}
