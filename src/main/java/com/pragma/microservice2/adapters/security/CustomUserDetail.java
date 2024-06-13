package com.pragma.microservice2.adapters.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUserDetail extends User {

    private final String dni;

    public CustomUserDetail(String dni, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }
}
