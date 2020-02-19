package com.lzhlyle.leetcode.tomorrow.no714;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) return 0;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < len; i++) {
            int oriDp0 = dp0;
            if (dp1 + prices[i] - fee > dp0) dp0 = dp1 + prices[i] - fee;
            if (oriDp0 - prices[i] > dp1) dp1 = oriDp0 - prices[i];
        }
        return dp0;
    }
}
