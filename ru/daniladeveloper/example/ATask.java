package ru.daniladeveloper.example;

public class ATask implements Runnable {

    State state;
    public void setState(State s) {
        state = s;
    }
    public void run() {
        System.out.println("A task started");
        state.setBoolState(false);
    }
}
