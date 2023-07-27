package ru.daniladeveloper.badexample;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CounterBadExample {

    public static void main(String[] args) throws InterruptedException {
        BadCounter c = new BadCounter();
        Runnable r = () -> {
            for (int i = 0;i < 1_000_000; i++) {
                c.x++; // BAD CODE! volatile not guarantee that arithmetic ops are atomic
            }
        };
        List<Thread> threads = Stream.generate(() -> new Thread(r))
            .limit(10).peek(Thread::start)
            .toList();
        for (Thread thread: threads) {
            thread.join();
        }
        System.out.println(c.x);
    }

}

