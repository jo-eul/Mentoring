package com.example.demo.week1.domain.user.entity.repository;

import com.example.demo.week1.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByName(String name);

    Boolean existsByName(String name);

}
