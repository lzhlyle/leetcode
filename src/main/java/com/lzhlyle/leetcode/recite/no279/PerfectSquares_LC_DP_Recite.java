package com.lzhlyle.leetcode.recite.no279;

public class PerfectSquares_LC_DP_Recite {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) dp[i] = i; // 最坏结果为 i 个 1
        for (int i = 0; i < n + 1; i++) { // 遍历
            for (int j = 0; j * j <= i; j++) { // 枚举所有完全平方数
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
