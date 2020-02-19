package com.lzhlyle.leetcode.tomorrow.no188;

public class BestTimeToBuyAndSellStockIV_DP {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        if (k > (len >> 1)) return _greedy(prices);

        int[][][] dp = new int[len][k + 1][2];
        for (int ki = 0; ki < k + 1; ki++) dp[0][ki][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            for (int ki = 1; ki < k + 1; ki++) {
                dp[i][ki][0] = Math.max(dp[i - 1][ki][0], dp[i - 1][ki][1] + prices[i]);
                dp[i][ki][1] = Math.max(dp[i - 1][ki][1], dp[i - 1][ki - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][k][0];
    }

    private int _greedy(int[] prices) {
        int max = 0, len = prices.length;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) max += prices[i] - prices[i - 1];
        }
        return max;
    }
}
