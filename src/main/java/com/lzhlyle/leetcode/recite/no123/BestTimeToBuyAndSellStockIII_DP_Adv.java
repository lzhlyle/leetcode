package com.lzhlyle.leetcode.recite.no123;

public class BestTimeToBuyAndSellStockIII_DP_Adv {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int dp00, dp01, dp10, dp11, dp20, dp21;
        dp00 = dp10 = dp20 = 0;
        dp01 = dp11 = dp21 = -prices[0];
        for (int i = 1; i < len; i++) {
            int oriDp10 = dp10;
            if (dp11 + prices[i] > dp10) dp10 = dp11 + prices[i];
            if (dp00 - prices[i] > dp11) dp11 = dp00 - prices[i];
            if (dp21 + prices[i] > dp20) dp20 = dp21 + prices[i];
            if (oriDp10 - prices[i] > dp21) dp21 = oriDp10 - prices[i];
        }
        return dp20;
    }
}
