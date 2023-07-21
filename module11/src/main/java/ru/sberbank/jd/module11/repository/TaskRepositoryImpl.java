package ru.sberbank.jd.module11.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.sberbank.jd.module11.model.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
@Slf4j
public class TaskRepositoryImpl implements TaskRepository {
    private final HashMap<String, Task> storage = new HashMap<>();
    @Override
    public Task save(Task t) {
        log.debug("[save] task={}", t);
        Task task = genedateIdIfEmpty(t);
        storage.put(t.getId(), task);
        return task;
    }

    @Override
    public List<Task> findAllByOwner(String owner) {
        return storage.values().stream()
                .filter(task -> task.getOwner().equalsIgnoreCase(owner))
                .toList();
    }

    private Task genedateIdIfEmpty(Task t) {
        if (t.getId().isEmpty()) {
            t.setId(UUID.randomUUID().toString());
        }
        return t;
    }
}
