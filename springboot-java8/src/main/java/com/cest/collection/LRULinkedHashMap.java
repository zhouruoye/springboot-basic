package com.cest.collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private int initialCapacity;

    public LRULinkedHashMap(int initialCapacity) {
        super(initialCapacity, 0.75f,true);
        this.initialCapacity = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > initialCapacity;
    }
}
