package ru.daniladeveloper.badexample;

import java.util.ArrayList;
import java.util.List;

public class BadContainer {

    // static

    private   final List<String> list = new ArrayList<>();

    /**
     * BAD CODE!
     * Так делать нельзя, так как лист статический,
     * но синхронизируемся по контейнеру this.
     * НО разделяемый ресурс будет один - list
     */
    synchronized void addEntry(String s) {
        list.add(s);
    }

    int size() {
        return list.size();
    }

}
