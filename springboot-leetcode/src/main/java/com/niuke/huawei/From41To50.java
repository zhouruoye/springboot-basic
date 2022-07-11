package com.niuke.huawei;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class From41To50 {

    public static void main(String[] args) {
        test45();
    }

    public static void test45() {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();

        for (int j = 0; j < Integer.valueOf(num); j++) {
            String str1 = sc.nextLine().toLowerCase();
            int[] letters = new int[26];

            for (int i = 0; i < str1.length(); i++) {
                char c = str1.charAt(i);
                letters[c - 97] = letters[c - 97] + 1;
            }

            List<Integer> collect = Arrays.stream(letters).boxed().sorted(Comparator.comparing(Integer::intValue).reversed()).collect(Collectors.toList());

            int maxCount = 0;
            for (int i = 0; i < collect.size(); i++) {
                maxCount += (collect.size() - i) * collect.get(i);
            }

            System.out.println(maxCount);
        }
    }


    public static void test46() {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        int sublength = sc.nextInt();
        System.out.println(str1.substring(0,sublength));
    }
}
