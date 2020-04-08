package com.lzhlyle.leetcode.recite.no1406;

public class StoneGameIii_DP_BottomUp {
    // dp
    public String stoneGameIII(int[] stoneValue) {
        int[] arr = new int[stoneValue.length + 2];
        System.arraycopy(stoneValue, 0, arr, 0, stoneValue.length);
        int len = arr.length;
        int[] dp = new int[len];
        int sum = dp[len - 3] = arr[len - 3];

        for (int i = len - 4; i >= 0; i--) {
            sum += arr[i];
            dp[i] = sum - Math.min(dp[i + 1], Math.min(dp[i + 2], dp[i + 3]));
        }

        int a = dp[0], b = sum - a;
        if (a == b) return "Tie";
        if (a > b) return "Alice";
        return "Bob";
    }
}
