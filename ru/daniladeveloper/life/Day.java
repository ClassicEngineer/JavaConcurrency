package ru.daniladeveloper.life;

import java.util.concurrent.atomic.AtomicInteger;

public class Day implements Runnable {

    {
        hour = new AtomicInteger();
    }
    private AtomicInteger hour;

    public void tick() {
        hour.incrementAndGet();
        if (hour.intValue() == 25) {
            hour.set(0);
            System.out.println("New Day: 00:00");
        } else {
            System.out.println("New hour: " + hour);
        }

    }

    public int getHour() {
        return hour.get();
    }

    @Override
    public void run() {
        while (true) {
            tick();
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setHour(int h) {
        this.hour.set(h);
    }
}
