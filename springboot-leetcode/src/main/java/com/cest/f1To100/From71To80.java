package com.cest.f1To100;

import java.util.ArrayList;
import java.util.List;

public class From71To80 {

    public static void main(String[] args) {
        From71To80 from71To80 = new From71To80();
        int[] ints39 = {2,0,2,1,1,0};
        from71To80.sortColors(ints39);
    }

    /**
     * 75. 颜色分类
     * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * 必须在不使用库的sort函数的情况下解决这个问题。
     * 输入：nums = [2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
     */
    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                red ++;
            } else if(nums[i] == 1) {
                white ++;
            }
        }

        white = red + white;

        for (int i = 0; i < nums.length; i++) {
            if(i < red) {
                nums[i] = 0;
            } else if(i >= red && i < white) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }

        System.out.println(nums);
    }

    /**
     * 78. 子集
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     * 示例 1：
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     * 输入：nums = [0]
     * 输出：[[],[0]]
     * 回溯算法
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0,nums,res,new ArrayList<>());
        return res;
    }

    /**
     * @param i
     * @param nums
     * @param res
     * @param tmp
     */
    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));

        for (int i1 = i; i1 < nums.length; i1++) {
            tmp.add(nums[i1]);
            backtrack(i1 + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
