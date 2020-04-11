package com.lzhlyle.leetcode.recite.no887;

public class SuperEggDrop_DP_BottomUp {
    // tle
    // O(k * n^2)
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int k = 1; k < K + 1; k++) dp[k][1] = 1;
        for (int n = 1; n < N + 1; n++) dp[1][n] = n;
        // dp[k][n] = min(dp[k][n], max(dp[k - 1][i - 1], dp[k][n - i]) + 1);
        for (int k = 2; k < K + 1; k++) {
            for (int n = 2; n < N + 1; n++) {
                dp[k][n] = n; // for min
                for (int i = 1; i <= n; i++) {
                    dp[k][n] = Math.min(dp[k][n], Math.max(dp[k - 1][i - 1], dp[k][n - i]) + 1);
                }
            }
        }
        return dp[K][N];
    }
}
