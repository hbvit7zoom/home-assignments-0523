package ru.sberbank.jd.webinar07.threads;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();

        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        myThread.join();
        thread.start();
//        thread.run();

        thread.join();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };

        System.out.println(Thread.currentThread().getName());
    }
}