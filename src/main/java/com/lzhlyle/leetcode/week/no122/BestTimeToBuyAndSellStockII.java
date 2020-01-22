package com.lzhlyle.leetcode.week.no122;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null) return 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int del = prices[i] - prices[i - 1];
            max += del > 0 ? del : 0;
        }
        return max;
    }
}
