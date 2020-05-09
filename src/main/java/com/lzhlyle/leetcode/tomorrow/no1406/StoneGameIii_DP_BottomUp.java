package com.lzhlyle.leetcode.tomorrow.no1406;

public class StoneGameIii_DP_BottomUp {
    // dp
    public String stoneGameIII(int[] stoneValue) {
        int len = stoneValue.length;
        int[] dp = new int[len + 2]; // ...?, 0, 0
        int sum = dp[len - 1] = stoneValue[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            sum += stoneValue[i];
            dp[i] = sum - Math.min(dp[i + 1], Math.min(dp[i + 2], dp[i + 3]));
        }
        int a = dp[0], b = sum - a;
        return a == b ? "Tie" : (a > b ? "Alice" : "Bob");
    }
}
