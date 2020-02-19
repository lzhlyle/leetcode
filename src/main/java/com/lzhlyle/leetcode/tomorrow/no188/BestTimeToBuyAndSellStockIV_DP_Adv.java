package com.lzhlyle.leetcode.tomorrow.no188;

public class BestTimeToBuyAndSellStockIV_DP_Adv {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        if (k > (len >> 1)) return _greedy(prices);

        int[][] dp = new int[k + 1][2];
        for (int ki = 0; ki < k + 1; ki++) dp[ki][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            for (int ki = 1; ki < k + 1; ki++) {
                int oriKi0 = dp[ki - 1][0];
                if (dp[ki][1] + prices[i] > dp[ki][0]) dp[ki][0] = dp[ki][1] + prices[i];
                if (oriKi0 - prices[i] > dp[ki][1]) dp[ki][1] = oriKi0 - prices[i];
            }
        }
        return dp[k][0];
    }

    private int _greedy(int[] prices) {
        int max = 0, len = prices.length;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) max += prices[i] - prices[i - 1];
        }
        return max;
    }
}
