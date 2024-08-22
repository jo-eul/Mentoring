package com.example.demo.week1.global.config.filter;

import com.example.demo.week1.global.error.exception.ExceptionFilter;
import com.example.demo.week1.global.security.jwt.JwtTokenFilter;
import com.example.demo.week1.global.security.jwt.JwtTokenProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final ObjectMapper objectMapper;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void configure(HttpSecurity builder) throws Exception{
        JwtTokenFilter jwtTokenFilter=new JwtTokenFilter(jwtTokenProvider);
        ExceptionFilter exceptionFilter=new ExceptionFilter(objectMapper);
        builder.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        builder.addFilterBefore(exceptionFilter,JwtTokenFilter.class);
    }
}
