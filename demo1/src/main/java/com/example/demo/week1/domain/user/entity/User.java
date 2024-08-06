package com.example.demo.week1.domain.user.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Builder
    public User(String name, String password){
        this.name=name;
        this.password=password;
    }
    public void update(String name){
        this.name=name;
    }
    public void ChangePassword(String password){
        this.password=password;
    }
}
