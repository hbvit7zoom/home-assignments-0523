package ru.sberbank.jd.module11.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.sberbank.jd.module11.controller.input.TaskInput;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Task {
    private String id;
    private final String owner;
    private final LocalDateTime createdDateTime;
    private String summary;
    private String description;
    private TaskStatus taskStatus;

    public static Task of(TaskInput input) {
        Task task = new Task(input.owner(), LocalDateTime.now());
        task.setId(UUID.randomUUID().toString());
        task.setSummary(input.summary());
        task.setDescription(input.description());
        task.setTaskStatus(TaskStatus.NEW);
        return task;
    }
}
