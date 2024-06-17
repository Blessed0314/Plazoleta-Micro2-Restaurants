package com.pragma.microservice2.adapters.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class CustomUserDetail extends User {

    private final String dni;
    private final String dniBoss;

    public CustomUserDetail(String dni, String dniBoss, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.dni = dni;
        this.dniBoss = dniBoss;
    }

}
