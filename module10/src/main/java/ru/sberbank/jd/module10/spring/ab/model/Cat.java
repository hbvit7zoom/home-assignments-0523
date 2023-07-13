package ru.sberbank.jd.module10.spring.ab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Cat {
    private final String id;
    private final String name;
    private final String age;
}
