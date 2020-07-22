package com.lzhlyle.leetcode.week.no64;

public class MinimumPathSum_DP_Adv {
    public int minPathSum(int[][] g) {
        int m = g.length, n = g[0].length;
        int[] dp = new int[n];
        dp[0] = g[0][0];
        for (int j = 1; j < n; j++)
            dp[j] += dp[j - 1] + g[0][j];

        for (int i = 1; i < m; i++) {
            dp[0] += g[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + g[i][j];
            }
        }
        return dp[n - 1];
    }
}
