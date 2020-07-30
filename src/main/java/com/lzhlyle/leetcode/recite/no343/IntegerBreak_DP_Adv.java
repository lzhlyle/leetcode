package com.lzhlyle.leetcode.recite.no343;

public class IntegerBreak_DP_Adv {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++)
            dp[i] = Math.max(Math.max(dp[i - 1], i - 1),
                    Math.max(2 * Math.max(dp[i - 2], i - 2),
                            3 * Math.max(dp[i - 3], i - 3)));
        return dp[n];
    }
}
