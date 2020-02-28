package com.lzhlyle.leetcode.recite.no337;

public class HouseRobberIii_DP {
    public int rob(TreeNode root) {
        int[] dp = dfs(root);
        return Math.max(dp[0], dp[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[2];
        int[] dp = new int[2], dpl = dfs(root.left), dpr = dfs(root.right);
        dp[0] = Math.max(dpl[0], dpl[1]) + Math.max(dpr[0], dpr[1]);
        dp[1] = root.val + dpl[0] + dpr[0];
        return dp;
    }
}
