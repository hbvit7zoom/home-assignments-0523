package ru.sberbank.jd.module13auth.security.model;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public enum Privilege implements GrantedAuthority {
    READ_USER("READ_USER"),
    WRITE_USER("WRITE_USER"),
    DELETE_USER("DELETE_USER");

    private final String value;

    @Override
    public String getAuthority() {
        return value;
    }
}
