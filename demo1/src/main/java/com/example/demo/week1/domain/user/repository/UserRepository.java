package com.example.demo.week1.domain.user.repository;

import com.example.demo.week1.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByName(String name);

    Boolean existsByName(String name);
}
