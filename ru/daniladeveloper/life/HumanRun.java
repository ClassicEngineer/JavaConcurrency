package ru.daniladeveloper.life;

import java.util.concurrent.Callable;

public class HumanRun implements Runnable, Callable {
    private static final int TIME_TO_GET_UP = 7;
    private Work work;
    private Home home;
    private String name;

    private Day day;
    private boolean isWakeUp;

    public HumanRun(Home home, Work work, String name) {
        this.home = home;
        this.work = work;
        this.name = name;

        this.isWakeUp = false;
    }

    public void liveIn(Day day) {
        this.day = day;
    }

    @Override
    public void run() {
        this.sleep();
        this.getUp();
        this.eat();
        this.goToWork();
        this.work();
        this.eat();
        this.work();
        this.goHome();
        this.eat();
        this.sleep();
    }

    public void wakeUp() {
        this.isWakeUp = true;
    }

    public void goToWork() {
        System.out.println("Human " + name + ": is going to go to work.");
        Address address = work.getAddress();
        this.walk(address);
        System.out.println("Human " + name + ": is now on work.");
    }

    public void getUp() {
        System.out.println("Human " + name + ": is going to get up.");
        wasteTime(3);
        System.out.println("Human " + name + ": is now get up.");
    }



    public void eat() {
        System.out.println("Human " + name + ": is going to EAT.");
        wasteTime(3);
        System.out.println("Human " + name + ": is now finished EAT.");
    }

    public void work() {
        System.out.println("Human " + name + ": is going to work hard.");
        Job job =  work.getJob();
        wasteTime(40);
        System.out.println("Human " + name + ": finish hard work.");
    }

    public void goHome() {
        System.out.println("Human " + name + ": is going to go to home.");
        Address address = home.getAddress();
        this.walk(address);
        System.out.println("Human " + name + ": is now at home.");
    }

    private void walk(Address address) {
        System.out.println("Walking!");
        wasteTime(5);
    }

    public void sleep() {
        while (day.getHour() < TIME_TO_GET_UP) {
            wasteTime(10);
            System.out.println("Human " + name + ": sleeping...");
        }
    }

    private void wasteTime(int seconds) {
        try {
            Thread.sleep(1000L * seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object call() throws Exception {
        return null;
    }
}
