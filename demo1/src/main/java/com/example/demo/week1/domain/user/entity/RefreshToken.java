package com.example.demo.week1.domain.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RefreshToken {
    @Id
    private String username;

    private String refreshToken;

    public void update(String token){
        this.refreshToken=token;
    }
}
