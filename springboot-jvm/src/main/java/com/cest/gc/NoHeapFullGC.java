package com.cest.gc;

import java.util.ArrayList;
import java.util.List;

public class NoHeapFullGC {
    static List<Class<?>> list = new ArrayList<Class<?>>();

    public static void main(String[] args) {
        while (true) {
            list.addAll(MyMetaspace.createClasses());
        }
    }
}
