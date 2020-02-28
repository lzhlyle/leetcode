package com.lzhlyle.leetcode.recite.no746;

public class MinCostClimbingStairs_DP {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len + 1; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]);
            if (i < len) dp[i] += cost[i];
        }
        return dp[len];
    }
}
