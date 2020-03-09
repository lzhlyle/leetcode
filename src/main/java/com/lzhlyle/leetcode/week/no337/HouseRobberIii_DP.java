package com.lzhlyle.leetcode.week.no337;

public class HouseRobberIii_DP {
    public int rob(TreeNode root) {
        int[] dp = _rob(root);
        return Math.max(dp[0], dp[1]);
    }

    private int[] _rob(TreeNode node) {
        if (node == null) return new int[2]; // 0:non, 1:rob
        int[] dp = new int[2], l = _rob(node.left), r = _rob(node.right);
        dp[0] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        dp[1] = l[0] + r[0] + node.val;
        return dp;
    }
}
