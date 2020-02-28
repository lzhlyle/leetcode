package com.lzhlyle.leetcode.recite.no337;

public class HouseRobberIii_Recursion_LC {
    public int rob(TreeNode root) {
        if (root == null) return 0;

        int sum = root.val;
        if (root.left != null) sum += rob(root.left.left) + rob(root.left.right);
        if (root.right != null) sum += rob(root.right.left) + rob(root.right.right);

        return Math.max(sum, rob(root.left) + rob(root.right));
    }
}
