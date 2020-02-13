package com.lzhlyle.leetcode.recite.no62;

public class UniquePaths_DP {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        // dp[i][j] = dp[i-1][j] + dp[i][j - 1]

        int[][] dp = new int[m][n];
        for (int r = 0; r < m; r++) dp[r][0] = 1;
        for (int c = 0; c < n; c++) dp[0][c] = 1;
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
