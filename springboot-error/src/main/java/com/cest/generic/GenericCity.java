package com.cest.generic;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GenericCity {

    /**
     * 泛型擦除
     */
    public static void easyUse() throws Exception {
        List<Integer> left = new ArrayList<>();
        List<String> right = new ArrayList<>();

        System.out.println(left.getClass());
        System.out.println(right.getClass());
        System.out.println(left.getClass() == right.getClass());

        if(left instanceof ArrayList) {
            System.out.println("ArrayList");
        }

        if(left instanceof ArrayList<?>) {
            System.out.println("ArrayList<?>");
        }

        //反射跳过泛型
        List<Integer> list = new ArrayList<>();
        list.add(1231);
        list.getClass().getMethod("add",Object.class).invoke(list,"哈哈哈");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.forEach(n -> System.out.println(n));

    }

    public static void main(String[] args) throws Exception {
        easyUse();
    }
}
