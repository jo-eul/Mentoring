package com.example.demo.week1.domain.user.entity.repository;

import com.example.demo.week1.domain.user.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken,Long> {
    Optional<RefreshToken> findByRefreshToken(String token);

}
