package ru.sberbank.jd.module09.classwork.service;

import ru.sberbank.jd.module09.classwork.model.CalcResult;

public interface CalculatorService {

    CalcResult sum(double p1, double p2);

    CalcResult findResultById(String id);
}
