package ru.sberbank.jd.module09.classwork.repository;

import ru.sberbank.jd.module09.classwork.model.CalcResult;

import java.util.Optional;

public interface CalcRepository {

    CalcResult save(CalcResult calcResult);
    boolean deleteById(String id);

    Optional<CalcResult> findById(String id);
}
