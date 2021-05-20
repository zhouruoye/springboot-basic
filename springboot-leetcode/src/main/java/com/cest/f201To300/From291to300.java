package com.cest.f201To300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class From291to300 {

    private Map<String, Integer> msgDict;

    public From291to300() {
        msgDict = new HashMap<String, Integer>();
    }

    public static void main(String[] args) {
        List<String> list = generatePossibleNextMoves("++++");
        System.out.println(111);
    }




    /**
     * 293. 翻转游戏
     * 你和朋友玩一个叫做「翻转游戏」的游戏。游戏规则如下：
     * 给你一个字符串 currentState ，其中只含 '+' 和 '-' 。你和朋友轮流将 连续 的两个 "++" 反转成 "--" 。当一方无法进行有效的翻转时便意味着游戏结束，则另一方获胜。
     * 计算并返回 一次有效操作 后，字符串 currentState 所有的可能状态，返回结果可以按 任意顺序 排列。如果不存在可能的有效操作，请返回一个空列表 [] 。
     * 示例 1：
     * 输入：currentState = "++++"
     * 输出：["--++","+--+","++--"]
     * 示例 2：
     * 输入：currentState = "+"
     * 输出：[]
     */
    public static List<String> generatePossibleNextMoves(String currentState) {
        List<String> list = new ArrayList<>();

        int length = currentState.length();

        for (int i = 0; i < length-1; i++) {
            if("+".equals(currentState.substring(i,i+1))
                    && "+".equals(currentState.substring(i+1,i+2))) {
                StringBuilder stringBuilder = new StringBuilder(currentState);
                stringBuilder.replace(i,i+2,"--");
                list.add(stringBuilder.toString());
            }
        }

        return list;
    }
}
