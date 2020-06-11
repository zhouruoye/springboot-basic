package com.cest.generic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 通过反射添加其它类型元素
 */
public class Test2 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> list = new ArrayList<>();

        list.add("1111");

        //        通过反射添加

        list.getClass().getMethod("add",Object.class).invoke(list,1111);

        for (String s : list) {
            System.out.println(s);
        }
    }
}
