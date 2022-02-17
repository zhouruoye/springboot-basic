package com.cest.gc;

import com.cest.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class HeapFullGC {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();

        while (true) {
            userList.add(new User());
        }
    }
}
