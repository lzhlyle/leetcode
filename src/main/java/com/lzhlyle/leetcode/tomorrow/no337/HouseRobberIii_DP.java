package com.lzhlyle.leetcode.tomorrow.no337;

public class HouseRobberIii_DP {
    public int rob(TreeNode root) {
        int[] dp = _rob(root);
        return Math.max(dp[0], dp[1]);
    }

    private int[] _rob(TreeNode root) {
        if (root == null) return new int[2];
        int[] dp = new int[2], dpl = _rob(root.left), dpr = _rob(root.right);
        dp[0] = Math.max(dpl[0], dpl[1]) + Math.max(dpr[0], dpr[1]);
        dp[1] = dpl[0] + dpr[0] + root.val;
        return dp;
    }
}
