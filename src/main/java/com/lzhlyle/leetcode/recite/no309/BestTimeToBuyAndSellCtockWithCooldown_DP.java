package com.lzhlyle.leetcode.recite.no309;

public class BestTimeToBuyAndSellCtockWithCooldown_DP {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int dp0 = 0, dp1 = -prices[0], dpPre0 = 0; // 0:empty, 1:hold
        for (int i = 1; i < len; i++) {
            int oriDp0 = dp0;
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, dpPre0 - prices[i]);
            dpPre0 = oriDp0;
        }
        return dp0;
    }
}
