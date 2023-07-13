package ru.sberbank.jd.module10.spring.ab.service;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.module10.spring.ab.repository.TaskRepository;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository repository;

    @PostConstruct
    public void test() {
        int i = 1;
        repository.hello();
    }
}
