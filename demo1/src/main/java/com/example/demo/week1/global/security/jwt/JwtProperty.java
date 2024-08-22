package com.example.demo.week1.global.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

import java.beans.ConstructorProperties;
@Getter
@ConfigurationProperties(prefix="spring.jwt")
@ConfigurationPropertiesScan
@AllArgsConstructor
public class JwtProperty {

    private final String SecretKey;
    private final Long accessExp;
    private final Long refreshExp;
    private final String header;
    private final String prefix;

}
