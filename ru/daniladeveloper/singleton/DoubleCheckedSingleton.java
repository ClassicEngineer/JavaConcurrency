package ru.daniladeveloper.singleton;

/**
 * This version of Singleton realize double-checked locking and not thread-safe
 */
public class DoubleCheckedSingleton {
    private static DoubleCheckedSingleton INSTANCE;

    int x = 1;


    static synchronized DoubleCheckedSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckedSingleton();
                }
            }
        }
        return INSTANCE;
    }

    private DoubleCheckedSingleton() {
        this.x = 1;
    }
}
