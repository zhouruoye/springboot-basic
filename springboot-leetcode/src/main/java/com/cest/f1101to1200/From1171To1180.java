package com.cest.f1101to1200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class From1171To1180 {

    public static void main(String[] args) {
//        System.out.println(countLetters("aaaaaaaaaa"));
        System.out.println(countLetters("aaaba"));
    }

    /**
     * 1180. 统计只含单一字母的子串
     * 给你一个字符串 S，返回只含 单一字母 的子串个数。
     * 输入： "aaaba"
     * 输出： 8
     * 解释：
     * 只含单一字母的子串分别是 "aaa"， "aa"， "a"， "b"。
     * "aaa" 出现 1 次。
     * "aa" 出现 2 次。
     * "a" 出现 4 次。
     * "b" 出现 1 次。
     * 所以答案是 1 + 2 + 4 + 1 = 8。
     *
     * @param s
     * @return
     */
    public static int countLetters(String s) {
        if(s == null) {
            return 0;
        }

        int length = s.length();

        List<String> list = new ArrayList<>();

        String tmp = s.substring(0,1);

        for (int i = 1; i < length; i++) {
            if(s.substring(i,i+1).equals(s.substring(i-1,i))) {
                tmp = tmp + s.substring(i,i+1);
            } else {
                list.add(tmp);
                tmp = s.substring(i,i+1);
            }

            if(i == s.length()-1) {
                    list.add(tmp);
                }
        }

        int count = 0;
        // 1 2 3
        // 1 1+2 1+2+3 (n+1)*n/2
        for (int i = 0; i < list.size(); i++) {
            String s1 = list.get(i);

            count += s1.length() * (s1.length() + 1)/2;
        }
        return count;
    }
}
