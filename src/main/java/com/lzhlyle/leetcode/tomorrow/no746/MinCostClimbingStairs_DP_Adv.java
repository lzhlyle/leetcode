package com.lzhlyle.leetcode.tomorrow.no746;

public class MinCostClimbingStairs_DP_Adv {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length, dp0 = cost[0], dp1 = cost[1];
        for (int i = 2; i < len; i++) {
            int next0 = dp1;
            dp1 = cost[i] + Math.min(dp0, dp1);
            dp0 = next0;
        }
        return Math.min(dp0, dp1);
    }
}
