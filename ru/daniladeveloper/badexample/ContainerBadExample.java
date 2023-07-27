package ru.daniladeveloper.badexample;

import java.util.ArrayList;
import java.util.List;

/** Bad example from
 * @see <a href = https://www.youtube.com/watch?v=ShzQJUFzq58>Tutorial<a/>
 */
public class ContainerBadExample {

    public static void main(String[] args) throws InterruptedException {
        BadContainer container = new BadContainer();
        Runnable foo = () -> {
            // BAD CODE! Container container = new Container();
            for (int i = 0; i < 100_000; i++) {
                container.addEntry("foo");
            }
        };
        List<Thread> threads = new ArrayList<>();
        for (int count = 10; count > 0; count--) {
            Thread thread = new Thread(foo);
            thread.start();
            threads.add(thread);
        }
//        for (Thread thread : threads) {
//            thread.join();
//        }
//
//        better than
//
//        while (container.size() < 1_000_000) {
//
//        }
//
//        because of:
//        inlining(открытая подстановка) possible
//
        System.out.println("Finished: " + container.size());
    }


}
