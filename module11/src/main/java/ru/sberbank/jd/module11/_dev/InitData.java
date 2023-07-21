package ru.sberbank.jd.module11._dev;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import ru.sberbank.jd.module11.controller.input.TaskInput;
import ru.sberbank.jd.module11.model.Task;
import ru.sberbank.jd.module11.service.TaskService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@RequiredArgsConstructor
@Component
@Profile("dev")
public class InitData {
    private final Environment environment;
    private final TaskService service;

    @PostConstruct
    public void initData() {
        log.debug("[initData] Dev profile activated, test data is creating ...");
        checkProfilePROD();
        TaskInput taskInput1 = new TaskInput("task1", "task1", "Nikita");
        TaskInput taskInput2 = new TaskInput("task2", "task2", "Nikita");
        TaskInput taskInput3 = new TaskInput("task3", "task3", "Nikita");
        TaskInput taskInput4 = new TaskInput("task4", "task4", "Nikita");

        List<Task> taskList = service.createAll(taskInput1, taskInput2, taskInput3, taskInput4);
        log.debug("[initData] tasks were created = {}", taskList);
    }
    private void checkProfilePROD() {
        if (Arrays.asList(environment.getActiveProfiles()).contains("PROD")) {
            throw new RuntimeException("Profile 'dev' must not be used with 'PROD', plz delete 'dev' profile and repeat.");
        }
        ;
    }
}
