package com.piti.java.hoteltesting.config.security.jwt;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

@SuppressWarnings("serial")
public class CustomUserDetails extends org.springframework.security.core.userdetails.User{
	private final Long id;

    public CustomUserDetails(Long id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
