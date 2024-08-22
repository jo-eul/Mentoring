package com.example.demo.week1.global.security.jwt;

import com.example.demo.week1.domain.user.entity.RefreshToken;
import com.example.demo.week1.domain.user.entity.repository.RefreshTokenRepository;
import com.example.demo.week1.global.security.auth.AuthDetails;
import com.example.demo.week1.global.security.auth.AuthDetailsService;
import com.example.demo.week1.global.exception.ExpiredTokenException;
import com.example.demo.week1.global.exception.InvalidTokenException;
import com.example.demo.week1.global.security.jwt.dto.TokenResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private final RefreshTokenRepository refreshTokenRepository;
    private final AuthDetailsService authDetailsService;
    private final JwtProperty jwtProperty;

    private static final String ACCESS_KEY = "assess_token";
    private static final String REFRESH_KEY = "refresh_token";

    public TokenResponse generateToken(String id, String role) {
        String accessToken = generateToken(id, ACCESS_KEY, role, jwtProperty.getAccessExp());
        LocalDateTime accessExpiredAt = LocalDateTime.now().withNano(0).plusSeconds(jwtProperty.getAccessExp());
        String refreshToken = generateToken(id, REFRESH_KEY, role, jwtProperty.getRefreshExp());
        LocalDateTime refreshExpiredAt = LocalDateTime.now().withNano(0).plusSeconds(jwtProperty.getRefreshExp());

        refreshTokenRepository.save(
                RefreshToken.builder()
                        .username(id)
                        .refreshToken(refreshToken)
                        .build()
        );
        return new TokenResponse(accessToken, refreshToken, accessExpiredAt, refreshExpiredAt);
    }

    private String generateToken(String id, String role, String type, Long exp) {
        return Jwts.builder()
                .setSubject(id)
                .setHeaderParam("typ", type)
                .claim("role", role)
                .signWith(SignatureAlgorithm.HS256, jwtProperty.getSecretKey())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .setIssuedAt(new Date())
                .compact();
    }

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader(jwtProperty.getHeader());
        if (bearer != null && bearer.startsWith(jwtProperty.getPrefix()) && bearer.length() > jwtProperty.getPrefix().length() + 1)
            return bearer.substring(jwtProperty.getPrefix().length() + 1);
        return null;
    }

    public Authentication authentication(String token) {
        Claims body = getJws(token).getBody();

        boolean isNotRefreshToken = !REFRESH_KEY.equals(getJws(token).getHeader().get("typ").toString());

        if ((!isNotRefreshToken)) throw InvalidTokenException.EXCEPTION;

        AuthDetails authDetails = getDetails(body);
        return new UsernamePasswordAuthenticationToken(authDetails, "", authDetails.getAuthorities());
    }

    public String getRole(String token) {
        return getJws(token).getBody().get("role").toString();
    }

    private Jws<Claims> getJws(String token) {
        try {
            return Jwts.parser().setSigningKey(jwtProperty.getSecretKey()).parseClaimsJws(token);
        } catch (ExpiredTokenException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }

    private AuthDetails getDetails(Claims body) {
        return authDetailsService.loadUserByUsername(body.getSubject());

    }
}

