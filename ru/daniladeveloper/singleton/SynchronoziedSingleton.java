package ru.daniladeveloper.singleton;

/**
 * This version of Singleton is laze and thread-safe
 */
public class SynchronoziedSingleton {
    private static SynchronoziedSingleton INSTANCE;

    int x = 1;


    static synchronized SynchronoziedSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SynchronoziedSingleton();
        }
        return INSTANCE;
    }

    private SynchronoziedSingleton() {
        this.x = 1;
    }
}
