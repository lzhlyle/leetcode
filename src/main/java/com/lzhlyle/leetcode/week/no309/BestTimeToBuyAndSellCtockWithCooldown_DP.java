package com.lzhlyle.leetcode.week.no309;

public class BestTimeToBuyAndSellCtockWithCooldown_DP {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int dp0 = 0, dp1 = -prices[0], dpPre0 = dp0; // pre day
        for (int i = 1; i < len; i++) {
            int next = dp0;
            if (dp1 + prices[i] > dp0) dp0 = dp1 + prices[i];
            if (dpPre0 - prices[i] > dp1) dp1 = dpPre0 - prices[i];
            dpPre0 = next;
        }
        return dp0;
    }
}
