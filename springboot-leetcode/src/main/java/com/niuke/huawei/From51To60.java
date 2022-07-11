package com.niuke.huawei;

import com.cest.pojo.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class From51To60 {

    public static void main(String[] args) {
//        test52();

    }

    public static void test51() {
        Scanner sc = new Scanner(System.in);
        String LinkNum = sc.nextLine();
        String nums = sc.nextLine();
        String[] s = nums.split(" ");
        ListNode listNode = new ListNode();
        for (int i = 0; i < s.length; i++) {

        }
    }

    public static void addLinkNode(ListNode listNode,Integer value) {

    }

    public static void test52() {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        int length1 = str1.length();
        int length2 = str2.length();

        String newStr2 = str2;

        //字符串求交集
        for (int i = 0; i < str1.length(); i++) {
            newStr2 = newStr2.replaceFirst(str1.substring(i,i+1),"");
        }

        int i = length2 - newStr2.length();


        System.out.println(length1 - i + newStr2.length());
    }
}
