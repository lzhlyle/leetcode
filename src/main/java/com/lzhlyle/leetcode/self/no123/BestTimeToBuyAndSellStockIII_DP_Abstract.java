package com.lzhlyle.leetcode.self.no123;

public class BestTimeToBuyAndSellStockIII_DP_Abstract {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int[][][] dp = new int[len][3][2]; // int[len][k + 1][2]
        dp[0][1][1] = dp[0][2][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            for (int k = 1; k < 3; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][2][0];
    }
}
