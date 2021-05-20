package com.cest.f201To300;


import java.util.HashMap;

public class From261to270 {

    public static void main(String[] args) {
        System.out.println(111);
    }

    /**
     * 266. 回文排列
     * 给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。
     * 示例 1：
     * 输入: "code"
     * 输出: false
     * 示例 2：
     * 输入: "aab"
     * 输出: true
     * 示例 3：
     * 输入: "carerac"
     * 输出: true
     */
    public boolean canPermutePalindrome(String s) {
        HashMap< Character, Integer > map = new HashMap < > ();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        for (char key: map.keySet()) {
            count += map.get(key) % 2;
        }
        return count <= 1;
    }
}
