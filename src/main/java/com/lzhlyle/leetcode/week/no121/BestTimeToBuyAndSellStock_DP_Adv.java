package com.lzhlyle.leetcode.week.no121;

public class BestTimeToBuyAndSellStock_DP_Adv {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int dp0 = 0, dp1 = -prices[0]; // 0:empty, 1:hold;
        for (int i = 1; i < len; i++) {
            if (dp1 + prices[i] > dp0) dp0 = dp1 + prices[i];
            if (-prices[i] > dp1) dp1 = -prices[i];
        }
        return dp0;
    }
}
