package ru.sberbank.jd.module09.classwork.service;

import ru.sberbank.jd.module09.classwork.model.CalcResult;
import ru.sberbank.jd.module09.classwork.repository.CalcRepository;

import java.util.UUID;

public class CalculatorServiceImpl implements CalculatorService {

    private CalcRepository repository;

    public CalculatorServiceImpl(CalcRepository repository) {
        this.repository = repository;
    }
    @Override
    public CalcResult sum(double p1, double p2) {
        double result = p1 + p2;
        CalcResult calcResult = new CalcResult(UUID.randomUUID().toString(), "sum", result);

        return repository.save(calcResult);
    }

    @Override
    public CalcResult findResultById(String id) {
        // todo обработать ситуацию, когда Optional.EMPTY
        return repository.findById(id).get();
    }
}
