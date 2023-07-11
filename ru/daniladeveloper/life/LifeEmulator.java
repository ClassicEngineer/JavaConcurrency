package ru.daniladeveloper.life;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class LifeEmulator {

    private ExecutorService humanExecutorService = new ThreadPoolExecutor(1, 1, 0L,
        TimeUnit.MILLISECONDS,
  new LinkedBlockingQueue<>());

    private ScheduledExecutorService timeExecutorService = Executors.newSingleThreadScheduledExecutor();

    public  void runInSeparateThread(Runnable task) {
        humanExecutorService.submit(task);
    }

    public <T>  void callInSeparateThread(Callable<T> task) {
        humanExecutorService.submit(task);
    }

    private void runBySchedule(Day daytime) {
        timeExecutorService.schedule(daytime, 1, TimeUnit.SECONDS);
    }

    public static HumanRun initHuman() {
        Home home = new Home();
        Work office = new Work();
        return new HumanRun(home, office, "Dan");
    }

    public static void main(String[] args) throws InterruptedException {
        LifeEmulator lifeEmulator = new LifeEmulator();

        List<Day> days = getSixDays(); // 1 day - 10 seconds
        HumanRun den = initHuman();

        Day daytime = days.get(0);
        daytime.setHour(5);
        //for (Day daytime : days) {
            den.liveIn(daytime);

            lifeEmulator.runInSeparateThread(den);
            lifeEmulator.runBySchedule(daytime);
        //}

    }

    private static List<Day> getSixDays() {
        return Stream.generate(Day::new).limit(6).toList();
    }


}
