package ru.sberbank.jd.module11.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.module11.controller.input.TaskInput;
import ru.sberbank.jd.module11.model.Task;
import ru.sberbank.jd.module11.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public Task createTask(TaskInput taskInput) {
        return taskRepository.save(Task.of(taskInput));
    }

    @Override
    public List<Task> createAll(TaskInput... input) {
        List<Task> tasks = new ArrayList<>();
        for (TaskInput ti: input) {
            tasks.add(createTask(ti));
        }
        return tasks;
    }

    @Override
    public List<Task> getTasks(String owner) {
        return taskRepository.findAllByOwner(owner);
    }
}
