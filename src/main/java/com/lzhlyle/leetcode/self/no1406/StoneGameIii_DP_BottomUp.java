package com.lzhlyle.leetcode.self.no1406;

import java.util.Arrays;

public class StoneGameIii_DP_BottomUp {
    // dp
    public String stoneGameIII(int[] stoneValue) {
        int[] arr = Arrays.copyOf(stoneValue, stoneValue.length + 2);
        int len = arr.length;
        int[] dp = new int[len];
        int sum = dp[len - 3] = arr[len - 3];
        for (int i = len - 4; i >= 0; i--) {
            sum += arr[i];
            dp[i] = sum - Math.min(dp[i + 1], Math.min(dp[i + 2], dp[i + 3]));
        }
        int a = dp[0], b = sum - a;
        return a == b ? "Tie" : (a > b ? "Alice" : "Bob");
    }
}
