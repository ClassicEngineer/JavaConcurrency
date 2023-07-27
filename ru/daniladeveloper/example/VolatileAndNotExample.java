package ru.daniladeveloper.example;

public class VolatileAndNotExample {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100_000; i++) {
            VolatileAndNot volatileAndNot = new VolatileAndNot();
            Thread threadA = new Thread(() -> {
                volatileAndNot.n = 1;
                volatileAndNot.v = 1;
            });

            Thread threadB = new Thread(() -> {
                while ( volatileAndNot.v != 1);
                System.out.println(volatileAndNot.n);

            });
            threadA.start(); threadB.start();
            threadA.join(); threadB.join();
        }
    }
}
