package ru.sberbank.jd.module11.service;

import ru.sberbank.jd.module11.controller.input.TaskInput;
import ru.sberbank.jd.module11.model.Task;

import java.util.List;

public interface TaskService {
    Task createTask(TaskInput taskInput);

    List<Task> createAll(TaskInput... input);

    List<Task> getTasks(String owner);
}
