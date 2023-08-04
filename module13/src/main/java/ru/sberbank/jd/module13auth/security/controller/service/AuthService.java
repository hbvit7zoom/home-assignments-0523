package ru.sberbank.jd.module13auth.security.controller.service;

import jakarta.security.auth.message.AuthException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.module13auth.security.controller.jwt.JwtRequest;
import ru.sberbank.jd.module13auth.security.controller.jwt.JwtResponse;
import ru.sberbank.jd.module13auth.security.jwt.JwtProvider;
import ru.sberbank.jd.module13auth.security.model.JwtAuthentication;
import ru.sberbank.jd.module13auth.user.model.User;
import ru.sberbank.jd.module13auth.user.service.UserService;

import java.util.HashMap;
import java.util.Map;

// eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwLmthbWlzaGV2IiwiZXhwIjoxNjc0NjY3MjIyLCJyb2xlcyI6WyJST0xFX1VTRVIiXSwicHJpdmlsZWdlcyI6WyJSRUFEX1VTRVIiXSwiZnVsbE5hbWUiOiJQYXZlbCBLYW1pc2hldiJ9.LMcw-sUTYcVgQWv6TyIz7ZIy9P7MelzfmENoRAJ5Iop4Lp1pn2q5LdtdjOPuYl3oWNp64j-oN1wJOUjMn9QahA
@Service
@RequiredArgsConstructor
public class AuthService {

    private final Map<String, String> refreshStorage = new HashMap<>();

    private final UserService userService;
    private final JwtProvider jwtProvider;

    @SneakyThrows
    public JwtResponse login(JwtRequest authRequest) {
        final User user = userService.getByLogin(authRequest.getUsername())
                .orElseThrow(() -> new AuthException("Пользователь не найден"));
        if (user.getPassword().equals(authRequest.getPassword())) {
            final String accessToken = jwtProvider.generateAccessToken(user);
            final String refreshToken = jwtProvider.generateRefreshToken(user);
            refreshStorage.put(user.getLogin(), refreshToken);
            return new JwtResponse(accessToken, refreshToken);
        } else {
            throw new AuthException("Неправильный пароль");
        }
    }

    public JwtAuthentication getAuthInfo() {
        return (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }
}
