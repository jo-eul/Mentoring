package com.example.demo.week1.global.security.auth;

import com.example.demo.week1.domain.user.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class AuthDetails implements UserDetails {
    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return authorities;
    }
    @Override
    public String getPassword(){
        return null;
    }

    @Override
    public String getUsername(){
        return user.getName();
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }
}
