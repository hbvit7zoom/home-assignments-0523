package ru.sberbank.jd.webinar07.threads;

import java.util.ArrayList;
import java.util.List;

public class CounterMain {

    public static void main(String[] args) {
        Counter counter = new Counter();

        List<Thread> threads = new ArrayList<>();

        for (int i=0; i < 1000; i++) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                counter.setCounter(counter.getCounter() + 1);
            });
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(counter.getCounter());
    }
}
