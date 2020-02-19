package com.lzhlyle.leetcode.tomorrow.no123;

public class BestTimeToBuyAndSellStockIII_DP_Abstract {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int[][][] dp = new int[len][3][2];
        for (int ki = 0; ki < 3; ki++) dp[0][ki][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            for (int ki = 1; ki < 3; ki++) {
                dp[i][ki][0] = Math.max(dp[i - 1][ki][0], dp[i - 1][ki][1] + prices[i]);
                dp[i][ki][1] = Math.max(dp[i - 1][ki][1], dp[i - 1][ki - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][2][0];
    }
}
