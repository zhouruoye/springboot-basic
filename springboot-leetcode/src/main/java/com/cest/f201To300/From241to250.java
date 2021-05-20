package com.cest.f201To300;

import java.util.ArrayList;
import java.util.List;

public class From241to250 {

    public static void main(String[] args) {
        String[] strings = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        shortestDistance(strings,"coding","practice");
        System.out.println(111);
    }

    /**
     * 243. 最短单词距离
     * 给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。
     * 示例:
     * 假设 words = ["practice", "makes", "perfect", "coding", "makes"]
     * 输入: word1 = “coding”, word2 = “practice”
     * 输出: 3
     * 输入: word1 = "makes", word2 = "coding"
     * 输出: 1
     */
    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        List<Integer> word1Location = new ArrayList<>();
        List<Integer> word2Location = new ArrayList<>();

        for (int i = 0; i < wordsDict.length; i++) {
            if(word1.equals(wordsDict[i])) {
                word1Location.add(i);
            }

            if(word2.equals(wordsDict[i])) {
                word2Location.add(i);
            }
        }

        List<Integer> location = new ArrayList<>();
        for (int i = 0; i < word1Location.size(); i++) {
            for (int i1 = 0; i1 < word2Location.size(); i1++) {
                location.add(Math.abs(word2Location.get(i1) - word1Location.get(i)));
            }
        }

        return location.stream().min((a,b) -> a -b).get();
    }
}
