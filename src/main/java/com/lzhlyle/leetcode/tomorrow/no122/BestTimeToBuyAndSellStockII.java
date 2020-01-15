package com.lzhlyle.leetcode.tomorrow.no122;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null) return 0;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum += Math.max(prices[i] - prices[i - 1], 0);
        }
        return sum;
    }
}
