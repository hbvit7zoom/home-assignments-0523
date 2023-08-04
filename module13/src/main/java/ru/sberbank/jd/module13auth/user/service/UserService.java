package ru.sberbank.jd.module13auth.user.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.module13auth.user.model.User;
import ru.sberbank.jd.module13auth.user.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> getByLogin(@NonNull String username) {
        return userRepository.findUserByLogin(username);
    }
}
