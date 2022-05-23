package com.cest.f601To700;

public class From641To650 {

    public static void main(String[] args) {
        int abc = countSubstrings("aaa");

        System.out.println(1111);
    }

    /**
     * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
     *
     * 回文字符串 是正着读和倒过来读一样的字符串。
     *
     * 子字符串 是字符串中的由连续字符组成的一个序列。
     *
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     * 示例 1：
     * 输入：s = "abc"
     * 输出：3
     * 解释：三个回文子串: "a", "b", "c"
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        if(s == null || "".equals(s)) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int i1 = i+1; i1 <= s.length(); i1++) {
                String substring = s.substring(i, i1);
                if(isPalindrome(substring)) {
                    count ++;
                }

            }
        }
        return count;
    }

    public static boolean isPalindrome(String result) {
        String reverse = new StringBuffer(result).reverse().toString();
        return result.equals(reverse);
    }
}
