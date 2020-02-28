package com.lzhlyle.leetcode.recite.no337;

public class HouseRobberIii_Recursion {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int non = dfs(root.left, false) + dfs(root.right, false);
        int rob = dfs(root.left, true) + dfs(root.right, true) + root.val;
        return Math.max(non, rob);
    }

    private int dfs(TreeNode root, boolean parentRob) {
        if (root == null) return 0;
        int non = dfs(root.left, false) + dfs(root.right, false);
        if (parentRob) return non;
        int rob = dfs(root.left, true) + dfs(root.right, true) + root.val;
        return Math.max(rob, non);
    }
}
