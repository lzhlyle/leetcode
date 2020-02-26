package com.lzhlyle.leetcode.week.no122;

public class BestTimeToBuyAndSellStockII_Greedy {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int max = 0;
        for (int i = 0; i + 1 < len; i++) {
            if (prices[i + 1] > prices[i]) max += prices[i + 1] - prices[i];
        }
        return max;
    }
}
