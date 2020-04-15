package com.lzhlyle.leetcode.tomorrow.no887;

public class SuperEggDrop_DP_BottomUp_BS {
    // O(k * n * log(n))
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int k = 1; k < K + 1; k++) dp[k][1] = 1;
        for (int n = 1; n < N + 1; n++) dp[1][n] = n;
        // dp[k][n] = min(dp[k][n], max(dp[k - 1][i - 1], dp[k][n - i]) + 1);
        for (int k = 2; k < K + 1; k++) {
            for (int n = 2; n < N + 1; n++) {
                // look for an "i", which make dp[k][n] min;
                int l = 1, r = n;
                while (l < r) {
                    int mid = l + ((r - l) >> 1);
                    int increasing = dp[k - 1][mid - 1], decreasing = dp[k][n - mid];
                    if (increasing < decreasing) l = mid + 1;
                    else r = mid;
                }
                dp[k][n] = Math.max(dp[k - 1][l - 1], dp[k][n - l]) + 1;
            }
        }
        return dp[K][N];
    }
}
