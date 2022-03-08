package com.cest.collection;

import java.util.Map;

public class LRUTest {

    public static void main(String[] args) {
        // 创建一个只有5个元素的缓存
        Map<Integer, Integer> lru = new LRULinkedHashMap<>(5);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.put(4, 4);
        lru.put(5, 5);
        lru.put(6, 6);
        lru.put(7, 7);

        System.out.println(lru.get(4));

        lru.put(6, 666);

        // 输出: {3=3, 5=5, 7=7, 4=4, 6=666}
        // 可以看到最旧的元素被删除了
        // 且最近访问的4被移到了后面
        System.out.println(lru);
    }
}
