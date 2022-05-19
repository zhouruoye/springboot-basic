package com.cest.f1To100;

import com.cest.pojo.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class From1To10 {

    String ans = "";

    public static void main(String[] args) {
        From1To10 f = new From1To10();
//        int abcabcbb = lengthOfLongestSubstring("au");
//        String babad = longestPalindrome("cbbd");
//        System.out.println(babad);

//        int[] ints = {2, 7, 11, 15};
//        int[] ints1 = twoSum1(ints, 9);
//        System.out.println(1);
//
//        ListNode h1 = new ListNode(2);
//        h1.next = new ListNode(4);
//        h1.next.next = new ListNode(3);
//
//        ListNode h2 = new ListNode(5);
//        h2.next = new ListNode(6);
//        h2.next.next = new ListNode(4);
//
//
//        ListNode listNode = f.addTwoNumbers(h1, h2);
//        System.out.println(listNode);

//        int[] ints1 = {1,2};
//        int[] ints2 = {3,4};
//        double medianSortedArrays = findMedianSortedArrays(ints1, ints2);
//        System.out.println(medianSortedArrays);

        int[] ints1 = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(ints1));

    }

    /**
     * 1. 两数之和
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int i1 = 0; i1 < nums.length; i1++) {
                if(i != i1) {
                    if(target == (num + nums[i1])) {
                        return new int[] {i, i1};
                    }
                }
            }
        }
        return new int[0];
    }

    /**
     * 1. 两数之和
     * hash法  这样我们创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
     */
    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(hashMap.containsKey(target - num)) {
                return new int[] {hashMap.get(target - num), i};
            }
            hashMap.put(num,i);
        }
        return new int[0];
    }

    /**
     * 2. 两数相加
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode move = head;

        //进位默认为0
        int carry = 0;

        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            int result =  (val1 + val2) + carry;

            carry = result / 10;
            result = result % 10;

            move.next = new ListNode(result);

            move = move.next;

            if(l1 != null) {
                l1 = l1.next;
            }

            if(l2 != null) {
                l2 = l2.next;
            }
        }

        if(carry == 1) {
            move.next = new ListNode(carry);
        }

        return head.next;
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

    /**
     * 4 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和nums2。请你找出并返回这两个正序数组的中位数 。
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        if(length1 == 0 || length2 == 0) {
            return length1 == 0 ? gethalfNum(nums2) : gethalfNum(nums1);
        }

        int totallength = length1 + length2;
        int i = 0,j = 0;
        int count = 0;
        int[] newNums = new int[totallength];

        while (totallength != (i + j)) {
            if(i == length1) {
                while (j != length2) {
                    newNums[count++] = nums2[j++];
                }
                break;
            }

            if(j == length2) {
                while (i != length1) {
                    newNums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                newNums[count++] = nums1[i++];
            } else {
                newNums[count++] = nums2[j++];
            }
        }

        return gethalfNum(newNums);
    }

    //获取中位数
    private static double gethalfNum(int[] res) {
        int n = res.length;
        if(n == 0) {
            return 0;
        }
        int a = res[(int) Math.round((double) n / 2 - 1)];
        int b = res[(int) Math.round((double) (n -1) / 2)];

        return (double) (a + b) / 2;
    }


    /**
     * todo 5. 最长回文子串
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 解题思路 去掉头尾 每个字符找最长回文串
     */
    public static String longestPalindrome(String s) {

        if (s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * 10 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 返回容器可以储存的最大水量。
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
     * 双指针法
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        if(height == null || height.length == 1) {
            return 0;
        }

        int start = 0;
        int end = height.length - 1;

        int max = 0;

        while(start != end) {
            max = Math.max(Math.min(height[start],height[end]) * (end - start),max);
            if(height[start] < height[end]) {
                start ++;
            } else {
                end --;
            }
        }
        return max;
    }
}
