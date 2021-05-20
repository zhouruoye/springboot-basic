package com.cest.f201To300;


import java.util.*;

public class From261to270 {

    public static void main(String[] args) {
        System.out.println(111);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 266. 回文排列
     * 给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。
     * 示例 1：
     * 输入: "code"
     * 输出: false
     * 示例 2：
     * 输入: "aab"
     * 输出: true
     * 示例 3：
     * 输入: "carerac"
     * 输出: true
     */
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        for (char key : map.keySet()) {
            count += map.get(key) % 2;
        }
        return count <= 1;
    }

    /**
     * 270. 最接近的二叉搜索树值
     * 给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。
     * 注意：
     * 给定的目标值 target 是一个浮点数
     * 题目保证在该二叉搜索树中只会存在一个最接近目标值的数
     * 示例：
     * 输入: root = [4,2,5,1,3]，目标值 target = 3.714286
     * 4
     * / \
     * 2   5
     * / \
     * 1   3
     * 输出: 4
     * 中序遍历
     */
    public int closestValue(TreeNode root, double target) {
        List<Integer> list = new ArrayList<>();
        midOrder(root, list);
        return Collections.min(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1;
            }
        });

    }

    private void midOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        midOrder(root.left, list);
        list.add(root.val);
        midOrder(root.right, list);
    }
}
