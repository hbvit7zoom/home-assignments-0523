package ru.sberbank.jd.module09.classwork.repository;

import ru.sberbank.jd.module09.classwork.model.CalcResult;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryCalcRepositoryImpl implements CalcRepository {
    private final Map<String, CalcResult> storage = new HashMap<>();

    @Override
    public CalcResult save(CalcResult calcResult) {
        storage.put(calcResult.getId(), calcResult);
        return calcResult;
    }

    @Override
    public boolean deleteById(String id) {
        if (storage.get(id) == null) {
            return false;
        } else {
            storage.remove(id);
            return true;
        }
    }

    @Override
    public Optional<CalcResult> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }
}
