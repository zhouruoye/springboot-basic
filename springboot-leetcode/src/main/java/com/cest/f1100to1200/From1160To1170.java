package com.cest.f1100to1200;

import java.util.HashMap;
import java.util.Map;

public class From1160To1170 {

    public static void main(String[] args) {
        String keyboard = "pqrstuvwxyzabcdefghijklmno";
        String word = "leetcode";
        calculateTime(keyboard,word);
    }

    /**
     * 1165. 单行键盘
     * 输入：keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba"
     * 输出：4
     * 解释：
     * 机械手从 0 号键移动到 2 号键来输出 'c'，又移动到 1 号键来输出 'b'，接着移动到 0 号键来输出 'a'。
     * 总用时 = 2 + 1 + 1 = 4.
     *
     * @param keyboard
     * @param word
     * @return
     */
    public static int calculateTime(String keyboard, String word) {
//        return solution1165_1(keyboard,word);
        return solution1165_2(keyboard,word);
    }

    /**
     * 第一种解法
     * @param keyboard
     * @param word
     * @return
     */
    private static int solution1165_1(String keyboard, String word) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < keyboard.length(); i++) {
            map.put(keyboard.substring(i,i+1),i+1);
        }

        if(word == null) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if(i == 0) {
                count += map.get(word.substring(i,i+1)) - 1;
            }else {
                count += Math.abs(map.get(word.substring(i,i+1)) - map.get(word.substring(i-1,i)));
            }
        }
        return count;
    }

    /**
     * 第二种解法
     * @param keyboard
     * @param word
     * @return
     */
    private static int solution1165_2(String keyboard, String word) {
        char[] chars = word.toCharArray();
        int count = 0;
        int index = 0;
        for (char aChar : chars) {
            int i = keyboard.indexOf(aChar);
            count += Math.abs(i - index);
            index = i;
        }

        return count;
    }

}
