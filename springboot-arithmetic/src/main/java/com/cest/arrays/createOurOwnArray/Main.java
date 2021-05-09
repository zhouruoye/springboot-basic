package com.cest.arrays.createOurOwnArray;

public class Main {

    public static void main(String[] args) {
        Array array = new Array(20);
        for (int i = 0; i < 10; i++) {
            array.addFirst(i);
            array.addLast(i);
        }

        array.remove(0);

        System.out.println("success");

    }
}
