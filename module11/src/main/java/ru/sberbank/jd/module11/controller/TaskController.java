package ru.sberbank.jd.module11.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.jd.module11.controller.input.TaskInput;
import ru.sberbank.jd.module11.model.Task;
import ru.sberbank.jd.module11.model.TaskStatus;
import ru.sberbank.jd.module11.service.TaskService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * PUT /task -- создание задачи
 * GET /task -- получение всех задач пользователя (paging)
 * GET /task/{id} -- получение конкретной задачи по id
 * GET /task?status={taskStatus} -- получение всех задач с указанным статусом для текущего пользователя (фильтрация)
 * POST /task -- создание и обновление задачи
 * PATCH /task/{id} -- обновление конкретных полей в задаче (передаем не весь JSON)
 * DELETE /task -- удаление всех задач пользователя
 * DELETE /task/{id} -- удаление конкретной задачи
 * DELETE /task?status={taskStatus} -- удаление всех задач с указанным статусом для текущего пользователя
 */

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
@Slf4j
public class TaskController {
    private final TaskService taskService;

    @PutMapping
    public Task createTask(@RequestBody TaskInput taskInput) {
        log.debug("[createTask] taskInput={}", taskInput);
        // validation here

        Task result = taskService.createTask(taskInput);
        return result;
    }

    @GetMapping
    public List<String> getTasks(@RequestHeader(name = "user") String user) {
        return taskService.getTasks(user).stream().map(Task::getId).toList();
    }
}
