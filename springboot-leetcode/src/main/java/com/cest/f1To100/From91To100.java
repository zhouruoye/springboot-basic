package com.cest.f1To100;

import com.cest.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class From91To100 {

    /**
     * 94. 二叉树的中序遍历
     * 二叉树的中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        return list;
    }

    /**
     * 96. 不同的二叉搜索树
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
     * 返回满足题意的二叉搜索树的种数。
     * 解题思路
     * 标签：动态规划
     * 假设 n 个节点存在二叉排序树的个数是 G (n)，令 f(i) 为以 i 为根的二叉搜索树的个数，则
     * G(n) = f(1) + f(2) + f(3) + f(4) + ... + f(n)G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)
     * 当 i 为根节点时，其左子树节点个数为 i-1 个，右子树节点为 n-i，则
     * f(i) = G(i-1)*G(n-i)f(i)=G(i−1)∗G(n−i)
     * 综合两个公式可以得到 卡特兰数 公式
     * G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)G(n)=G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)
     */
    public int numTrees(int n) {

        return 0;
    }


    /**
     * 98. 验证二叉搜索树
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     * 有效 二叉搜索树定义如下：
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);

        for (int i = 1; i < list.size(); i++) {
            if(list.get(i) <= list.get(i-1)) {
                return false;
            }
        }

        return true;
    }


    private void inOrder(TreeNode node,List<Integer> list) {
        if (node == null) {
            return;
        }

        inOrder(node.left,list);
        list.add(node.val);
        inOrder(node.right,list);
    }
}
