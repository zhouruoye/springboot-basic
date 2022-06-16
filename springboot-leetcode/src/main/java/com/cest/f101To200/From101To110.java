package com.cest.f101To200;

import com.cest.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class From101To110 {

    public static void main(String[] args) {
        TreeNode level31 = new TreeNode(3);
        TreeNode level32 = new TreeNode(3);

        TreeNode level21 = new TreeNode(2);
        TreeNode level22 = new TreeNode(2);

        level21.right = level31;
        level22.right = level32;

        TreeNode root = new TreeNode(1);
        root.left = level21;
        root.right = level22;

        From101To110 from101To110 = new From101To110();
        from101To110.isSymmetric(root);
    }


    /**
     * 101. 对称二叉树
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     * 示例 1：
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     * 示例 2：
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     */
    public boolean isSymmetric(TreeNode root) {
        List<String> list = new ArrayList<>();
        inOrder(root,list);
        return list.size() == 0;
    }

    private void inOrder(TreeNode node, List<String> list) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }

        if((node.left == null && node.right != null) ||
                (node.right == null && node.left != null) ||
                (node.right.val != node.left.val)) {
            list.add("1");
        }
        inOrder(node.left,list);
        inOrder(node.right,list);
    }
}
