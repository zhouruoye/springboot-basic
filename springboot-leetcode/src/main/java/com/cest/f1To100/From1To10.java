package com.cest.f1To100;

import java.util.HashSet;
import java.util.Set;

public class From1To10 {

    public static void main(String[] args) {
        int abcabcbb = lengthOfLongestSubstring("au");

        System.out.println(abcabcbb);
    }

    /**
     * 3. 无重复字符的最长子串
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * 示例：
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */
    public static int lengthOfLongestSubstring(String s) {
        //滑动窗口
        int length = s.length();

        int start = 1;
        int end = 0;

        int maxLength = 0;

        while (start <= length) {
            String substring = s.substring(end, start);

            if (isRepeatString(substring)) {
                start++;
                int length1 = substring.length();
                maxLength = maxLength > length1 ? maxLength : length1;
            } else {
                end++;
            }
        }

        return maxLength;
    }

    private static boolean isRepeatString(String s) {
        int length = s.length();

        Set<String> set = new HashSet<>();

        for (int i = 0; i < length; i++) {
            set.add(s.substring(i, i + 1));
        }
        return length == set.size();
    }
}
