package com.lzhlyle.leetcode.week.no343;

public class IntegerBreak_DP_Adv {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int i1 = Math.max(i - 1, dp[i - 1]);
            int i2 = 2 * Math.max(i - 2, dp[i - 2]);
            int i3 = 3 * Math.max(i - 3, dp[i - 3]);
            dp[i] = Math.max(i1, Math.max(i2, i3));
        }
        return dp[n];
    }
}
