package ru.sberbank.jd.module11.repository;

import ru.sberbank.jd.module11.model.Task;

import java.util.List;

public interface TaskRepository {
    Task save(Task t);
    List<Task> findAllByOwner(String owner);
}
