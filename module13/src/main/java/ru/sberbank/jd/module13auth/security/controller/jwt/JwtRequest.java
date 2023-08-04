package ru.sberbank.jd.module13auth.security.controller.jwt;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JwtRequest {

    private String username;
    private String password;
}
