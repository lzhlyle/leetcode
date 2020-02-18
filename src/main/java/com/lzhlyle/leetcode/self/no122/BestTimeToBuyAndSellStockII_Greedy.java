package com.lzhlyle.leetcode.self.no122;

public class BestTimeToBuyAndSellStockII_Greedy {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int max = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) max += prices[i] - prices[i - 1];
        }
        return max;
    }
}
