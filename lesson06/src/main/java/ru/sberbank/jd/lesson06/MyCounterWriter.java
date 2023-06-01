package ru.sberbank.jd.lesson06;

public abstract class MyCounterWriter implements Writer, Counter {
    @Override
    public void count() {

    }

    public abstract void write();
}
