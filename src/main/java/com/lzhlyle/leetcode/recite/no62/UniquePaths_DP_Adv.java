package com.lzhlyle.leetcode.recite.no62;

import java.util.Arrays;

public class UniquePaths_DP_Adv {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                dp[c] += dp[c - 1];
            }
        }

        return dp[n - 1];
    }
}
