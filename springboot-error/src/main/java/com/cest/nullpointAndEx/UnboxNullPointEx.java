package com.cest.nullpointAndEx;

/**
 * 自动拆装箱出现空指针
 */
public class UnboxNullPointEx {

    public static int add(int x,int y) {
        return x+y;
    }

    public static boolean compare(int x,int y) {
        return x >= y;
    }


    public static void main(String[] args) {
        // 1 包装类型为null -->（自动拆箱） 变为基本类型
//        Integer count = null;
//        int count_ = count;

        // 2 方法传参自动拆箱出现空指针
//        Integer x = null;
//        Integer y = 1;
//        System.out.println(add(x,y));

        // 3 比较大小有值为null
        Integer x = null;
        Integer y = 1;
        System.out.println(compare(x,y));
    }
}
