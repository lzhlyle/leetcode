package com.lzhlyle.leetcode.recite.no343;

public class IntegerBreak_DP {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++)
            dp[i] = i - 1;
        for (int i = 2; i <= n; i++)
            for (int j = i - 2; j > 1; j--)
                dp[i] = Math.max(dp[i], j * Math.max(i - j, dp[i - j]));
        return dp[n];
    }
}
