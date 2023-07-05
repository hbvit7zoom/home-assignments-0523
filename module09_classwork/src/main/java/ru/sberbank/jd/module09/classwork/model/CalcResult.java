package ru.sberbank.jd.module09.classwork.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class CalcResult {
    final private String id;
    final private String operation;
    final private Double result;
}
