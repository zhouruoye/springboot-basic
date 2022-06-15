package com.cest.f1To100;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class From41To50 {

    public static void main(String[] args) {

        From41To50 to50 = new From41To50();
        int[] ints39 = {1,2,3};
        List<List<Integer>> permute = to50.permute(ints39);
        System.out.println(111);
    }

    /**
     * 46. 全排列
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * 示例 1：
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 回溯法
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> output = Arrays.stream(nums).boxed().collect(Collectors.toList());

        int length = nums.length;

        backtrack(length,output,res,0);

        return res;
    }

    /**
     * 48. 旋转图像
     * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[[7,4,1],[8,5,2],[9,6,3]]
     *
     * 提示：自外向内一共有不超过 n/2n/2 层（单个中心元素不算一层）矩形框。对于第 timestimes 层矩形框，其框边长 len=nums-(times*2)len=nums−(times∗2)，
     * 将其顺时针分为 44 份 len-1len−1 的边，对四条边进行元素的循环交换即可。
     */
    public void rotate(int[][] matrix) {
        //校验数组长度>0 且是正方形数组

        //数组长度为
        int length = matrix.length;
        //设置层数 最外层为0
        int times = 0;

        while((times + 1) << 1 <= length) {
            int len = length - (times << 1);
            for(int i = 0; i < len - 1; ++i){
                int temp = matrix[times][times + i];
                matrix[times][times + i] = matrix[times + len - i - 1][times];
                matrix[times + len - i - 1][times] = matrix[times + len - 1][times + len - i - 1];
                matrix[times + len - 1][times + len - i - 1] = matrix[times + i][times + len - 1];
                matrix[times + i][times + len - 1] = temp;
            }

            //加一层
            times ++;
        }
    }


    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
     * 示例 1:
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * 分组排序
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> collect = Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    // 返回 str 排序后的结果。
                    // 按排序后的结果来grouping by，算子类似于 sql 里的 group by。
                    char[] array = str.toCharArray();
                    Arrays.sort(array);
                    return new String(array);
                }));
        return new ArrayList<>(collect.values());
    }


    /**
     * @param length 数组长度
     * @param output 数组转List
     * @param res 结果集
     * @param first 层级
     */
    public void backtrack(int length, List<Integer> output, List<List<Integer>> res, int first) {
        //说明层级相等 已经到达叶子节点
        if(first == length) {
            res.add(new ArrayList<Integer>(output));
        }

        //进行遍历
        for (int i = first; i < length; i++) {
            //对数组进行替换
            Collections.swap(output, first, i);
            backtrack(length,output,res,first+1);
            //对数组进行复原
            Collections.swap(output, first, i);
        }

    }


}
