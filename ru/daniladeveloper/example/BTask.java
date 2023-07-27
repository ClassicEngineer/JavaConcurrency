package ru.daniladeveloper.example;

public class BTask implements Runnable {


    public State state;

    public void setState(State s) {
        state = s;
    }
    public void run() {
        System.out.println("B task started");
        state.setBoolState(true);
    }
}
