package com.lzhlyle.leetcode.self.no279;

public class PerfectSquares_LC_DP {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = i;
            for (int j = 0; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
