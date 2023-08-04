package ru.sberbank.jd.module13auth._dev;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.sberbank.jd.module13auth.security.model.Privilege;
import ru.sberbank.jd.module13auth.user.model.Role;
import ru.sberbank.jd.module13auth.user.model.User;
import ru.sberbank.jd.module13auth.user.repository.RoleRepository;
import ru.sberbank.jd.module13auth.user.repository.UserRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
@Profile({"test-data"})
public class InitTestData {
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @PostConstruct
    public void handleStartedEvent() {
        log.info("Initiating test data ...");
        var adminRole = new Role();
        adminRole.setPrivileges(List.of(Privilege.WRITE_USER, Privilege.READ_USER, Privilege.DELETE_USER));
        adminRole.setRoleName(ROLE_ADMIN);
        roleRepository.save(adminRole);
        log.info("role added '{}'", adminRole);

        var user = new User();
        user.setFullName("Maria Ivanova");
        user.setLogin("m.ivanova");
        user.setPassword("1234");
        user.setRoles(List.of(adminRole));
        userRepository.save(user);
        log.info("user added '{}'", user);

        var userRole = new Role();
        userRole.setPrivileges(List.of(Privilege.READ_USER));
        userRole.setRoleName(ROLE_USER);
        roleRepository.save(userRole);
        log.info("role added '{}'", userRole);

        var user2 = new User();
        user2.setFullName("Pavel Kamishev");
        user2.setLogin("p.kamishev");
        user2.setPassword("1234");
        user2.setRoles(List.of(userRole));
        userRepository.save(user2);
        log.info("user added '{}'", user2);
    }
}
