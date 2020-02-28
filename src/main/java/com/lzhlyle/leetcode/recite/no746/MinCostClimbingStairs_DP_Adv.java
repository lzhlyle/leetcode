package com.lzhlyle.leetcode.recite.no746;

public class MinCostClimbingStairs_DP_Adv {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length, dp0 = cost[0], dp1 = cost[1];
        for (int i = 2; i < len + 1; i++) {
            int next0 = dp1;
            if (dp0 < dp1) dp1 = dp0;
            if (i < len) dp1 += cost[i];
            dp0 = next0;
        }
        return dp1;
    }
}
