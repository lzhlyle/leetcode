package com.lzhlyle.leetcode.tomorrow.no221;

public class MaximalSquare_DP {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length < 1 || matrix[0].length < 1) return 0;

        int x = matrix.length, y = matrix[0].length, max = 0;
        int[][] dp = new int[x + 1][y + 1];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
                    max = Math.max(max, dp[i + 1][j + 1]);
                }
            }
        }
        return max * max;
    }
}
