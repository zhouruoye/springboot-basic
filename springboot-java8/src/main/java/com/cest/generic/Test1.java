package com.cest.generic;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试泛型擦除
 * 原始类型相等 最后返回结果true
 */
@Slf4j
public class Test1 {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("1");

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);

        boolean flag = list1.getClass() == list2.getClass();

        System.out.println(flag);
    }
}
