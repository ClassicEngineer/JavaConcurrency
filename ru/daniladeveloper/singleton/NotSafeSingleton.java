package ru.daniladeveloper.singleton;

/**
 * This version of Singleton not thread-safe
 */
public class NotSafeSingleton {
    private static NotSafeSingleton INSTANCE;

    int x = 1;


    static NotSafeSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NotSafeSingleton();
        }
        return INSTANCE;
    }

    private NotSafeSingleton() {
        this.x = 1;
    }
}
