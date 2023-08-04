package ru.sberbank.jd.module13auth.security;

import io.jsonwebtoken.Claims;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.sberbank.jd.module13auth.security.model.JwtAuthentication;
import ru.sberbank.jd.module13auth.security.model.Privilege;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JwtUtils {

    public static JwtAuthentication generate(Claims claims) {
        final JwtAuthentication jwtInfoToken = new JwtAuthentication();
        jwtInfoToken.setPrivileges(getPrivileges(claims));
        jwtInfoToken.setFullName(claims.get("firstName", String.class));
        jwtInfoToken.setUsername(claims.getSubject());
        return jwtInfoToken;
    }

    private static Set<Privilege> getPrivileges(Claims claims) {
        final List<String> privileges = claims.get("privileges", List.class);
        return privileges.stream()
                .map(Privilege::valueOf)
                .collect(Collectors.toSet());
    }

}
