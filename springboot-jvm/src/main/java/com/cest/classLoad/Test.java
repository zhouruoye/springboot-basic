package com.cest.classLoad;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        {
            byte[] place = new byte[64 * 1024 * 1024];
        }
        int a;
        //只有直接定义这个类的字段才会初始化
//        System.out.println(SubClass.value);
//      数组定义也不会初始化类 字节码指令newarray
//        SuperClass[] superClasses = new SuperClass[10];
//        List<SuperClass> superClasses1 = new ArrayList<>();

        System.gc();


    }
}
