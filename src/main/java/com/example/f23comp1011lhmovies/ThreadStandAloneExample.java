package com.example.f23comp1011lhmovies;

public class ThreadStandAloneExample {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.printf("Thread: %s count: %d%n", Thread.currentThread().getName(), i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.printf("Thread %s is finished%n", Thread.currentThread().getName());
        };

        Thread thread1 = new Thread(runnable, "Thread 1");
        Thread thread2 = new Thread(runnable, "Thread 2");
        Thread thread3 = new Thread(runnable, "Thread 3");
        Thread thread4 = new Thread(runnable, "Thread 4");
        Thread thread5 = new Thread(runnable, "Thread 5");

        Thread newThread = new Thread("New Thread"){

            @Override
            public void run(){
                for (int i = 1; i <= 5; i++) {
                    System.out.printf("Thread: %s count: %d%n", Thread.currentThread().getName(), i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.printf("Thread %s is finished%n", Thread.currentThread().getName());
            }
        };

        newThread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
