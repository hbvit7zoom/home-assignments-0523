package ru.sberbank.jd.module10.spring.ab.repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DbTaskRepository implements TaskRepository{
    public void hello() {
        log.info("DbTaskRepository");
    }
}
