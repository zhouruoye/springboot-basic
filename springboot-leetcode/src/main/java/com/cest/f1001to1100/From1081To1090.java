package com.cest.f1001to1100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class From1081To1090 {

    public static void main(String[] args) {
//        1085. 最小元素各数位之和
//        int[] nums = new int[]{34,23,1,24,75,33,54,8};
//        sumOfDigits(nums);


        int [] intA[] ={{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        highFive(intA);
    }

    /**
     * 1085. 最小元素各数位之和
     * 给你一个正整数的数组 A。
     * 然后计算 S，使其等于数组 A 当中最小的那个元素各个数位上数字之和。
     * 最后，假如 S 所得计算结果是 奇数 ，返回 0 ；否则请返回 1。
     * 输入：[34,23,1,24,75,33,54,8]
     * 输出：0
     * 解释：
     * 最小元素为 1 ，该元素各个数位上的数字之和 S = 1 ，是奇数所以答案为 0 。
     * @param nums
     * @return
     */
    public static int sumOfDigits(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(min > nums[i]) {
                min = nums[i];
            }
        }

        int length = String.valueOf(min).length();

        int count = 0;

        for (int i = 0; i < length; i++) {
            count += min % 10;
            min = min/10;
        }
        return count % 2 == 0 ? 1 : 0;
    }

    /**
     * 1086. 前五科的均分
     * 给你一个不同学生的分数列表 items，其中 items[i] = [IDi, scorei] 表示 IDi 的学生的一科分数，你需要计算每个学生 最高的五科 成绩的 平均分。
     * 返回答案 result 以数对数组形式给出，其中 result[j] = [IDj, topFiveAveragej] 表示 IDj 的学生和他 最高的五科 成绩的 平均分。result 需要按 IDj  递增的 顺序排列 。
     * 学生 最高的五科 成绩的 平均分 的计算方法是将最高的五科分数相加，然后用 整数除法 除以 5 。
     * 输入：items = [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
     * 输出：[[1,87],[2,88]]
     * 解释：
     * ID = 1 的学生分数为 91、92、60、65、87 和 100 。前五科的平均分 (100 + 92 + 91 + 87 + 65) / 5 = 87
     * ID = 2 的学生分数为 93、97、77、100 和 76 。前五科的平均分 (100 + 97 + 93 + 77 + 76) / 5 = 88.6，但是由于使用整数除法，结果转换为 88
     */
    public static int[][] highFive(int[][] items) {
        // 整理 items
        // 对于 id 从小到大排序
        // 对于分数，从大到小排序
//        Arrays.sort(items,(a,b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));

        Map<Integer, List<Integer>> maps = new HashMap();
        for (int[] item : items) {
            List<Integer> list = null;
            if(maps.containsKey(item[0])) {
                list = maps.get(item[0]);
            }else {
                list = new ArrayList<>();
            }
            list.add(item[1]);
            maps.put(item[0],list);
        }

        int[][] res = new int[maps.size()][2];
        int num = 0;
        for (Map.Entry<Integer, List<Integer>> entry : maps.entrySet()) {
            List<Integer> value = entry.getValue();
            value.sort((a,b) -> b -a);

            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += value.get(i);
            }

            res[num][0] = entry.getKey();
            res[num][1] = sum/5;
            num++;
        }

        return res;
    }
}
