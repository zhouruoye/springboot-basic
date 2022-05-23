package com.cest.f1To100;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class From11To20 {

    public static void main(String[] args) {
//        int[] nums = {-1,0,1,2,-1,-4};
//        List<List<Integer>> lists = threeSum(nums);

        List<String> list = letterCombinations("23");
        System.out.println(1111);
    }

    /**
     * 15. 三数之和
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 思路：
     * 标签：数组遍历
     * 首先对数组进行排序，排序后固定一个数 nums[i]nums[i]，再使用左右指针指向 nums[i]nums[i]后面的两端，数字分别为 nums[L]nums[L] 和 nums[R]nums[R]，计算三个数的和 sumsum 判断是否满足为 00，满足则添加进结果集
     * 如果 nums[i]nums[i]大于 00，则三数之和必然无法等于 00，结束循环
     * 如果 nums[i]nums[i] == nums[i-1]nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
     * 当 sumsum == 00 时，nums[L]nums[L] == nums[L+1]nums[L+1] 则会导致结果重复，应该跳过，L++L++
     * 当 sumsum == 00 时，nums[R]nums[R] == nums[R-1]nums[R−1] 则会导致结果重复，应该跳过，R--R−−
     * 时间复杂度：O(n^2)O(n
     * 2
     *  )，nn 为数组长度
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        //如果为null 或者 小于3 则直接返回空
        if(nums == null || nums.length < 3) {
            return list;
        }

        int length = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < length; i++) {
            //如果当前数组大于0 直接退出
            if(nums[i] > 0) {
                break;
            }

            if(i > 0 && nums[i] == nums[i-1]) {
                continue; // 去重
            }

            int L = i+1;
            int R = length-1;

            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    list.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) {
                        L++; // 去重
                    }
                    while (L<R && nums[R] == nums[R-1]) {
                        R--; // 去重
                    }
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    R--;
                }
            }
        }
        return list;
    }

    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };


    /**
     * 17. 电话号码的字母组合
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * 示例 1：
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     */
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();

        if(digits == null || "".equals(digits)) {
            return list;
        }

        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        //递归处理
        addPhoneNums(digits,list,phoneMap,0,"");

        return list;
    }

    private static void addPhoneNums(String digits, List<String> list, Map<Character, String> phoneMap, int index,String s) {
        List<String> newlist = new ArrayList<>();

        if(digits.length() == index) {
            list.add(s);
            return;
        }

        Character c = digits.charAt(index);

        if(phoneMap.containsKey(c)) {
            String key = phoneMap.get(c);
            for (int i = 0; i < key.length(); i++) {
                addPhoneNums(digits,list,phoneMap, index + 1,s + key.charAt(i));
            }
        }
    }
}
