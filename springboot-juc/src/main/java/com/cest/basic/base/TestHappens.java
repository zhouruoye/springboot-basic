package com.cest.basic.base;

public class TestHappens {

    private static String var = "222";

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(var);
        });

        var = "111";

        thread.start();
    }
}
