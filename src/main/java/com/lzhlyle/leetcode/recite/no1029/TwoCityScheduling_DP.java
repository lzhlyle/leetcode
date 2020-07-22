package com.lzhlyle.leetcode.recite.no1029;

public class TwoCityScheduling_DP {
    // O(n/2 * n/2)
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            dp[i][0] = costs[i - 1][0] + dp[i - 1][0];
        for (int j = 1; j <= n; j++)
            dp[0][j] = costs[j - 1][1] + dp[0][j - 1];

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = Math.min(
                        dp[i - 1][j] + costs[i + j - 1][0],
                        dp[i][j - 1] + costs[i + j - 1][1]
                );
        return dp[n][n];
    }
}
