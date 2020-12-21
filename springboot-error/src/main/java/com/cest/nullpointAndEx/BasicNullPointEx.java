package com.cest.nullpointAndEx;

import java.util.ArrayList;
import java.util.List;

/**
 * String 数组 集合 空指针
 */
public class BasicNullPointEx {

    public static boolean stringEquals(String x,String y) {
        return x.equals(y);
    }
    
    public static class User {
        private String name;
    }

    public static void main(String[] args) {
        // 1 字符串 null
//        System.out.println(stringEquals("111",null));
//        System.out.println(stringEquals(null,"111"));

        // 2 数组空指针 对象数组new出来 但是对象元素没有初始化
        int length = 10;
        User[] users = new User[length];

        for (int i = 0; i < length; i++) {
            users[i] = new User(); // --> 改进 每个元素都需要new
            users[i].name = "dada" + i;
        }

        // 3 List 使用addAll 传递null
        List<User> userList = new ArrayList<>();
        User user = null;
        List<User> userList_ = null;
        userList.add(user);
        userList.addAll(userList_);

    }
}
