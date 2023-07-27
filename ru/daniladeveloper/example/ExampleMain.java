package ru.daniladeveloper.example;

public class ExampleMain {


    public static void main(String[] args) throws InterruptedException {
        State state = new State();

        ATask a = new ATask();
        BTask b = new BTask();

        a.setState(state);
        b.setState(state);

        Thread threadA = new Thread(a);
        Thread threadB = new Thread(b);

        threadA.start();
        threadB.start();

        Thread.sleep(300);
        System.out.println(state); // result is unexpected
    }

}
