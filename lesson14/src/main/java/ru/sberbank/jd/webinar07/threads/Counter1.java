package ru.sberbank.jd.webinar07.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter1 {

    private AtomicInteger counter = new AtomicInteger();

    public AtomicInteger getCounter() {
        return counter;
    }

    public void setCounter(AtomicInteger counter) {
        this.counter = counter;
    }
}
