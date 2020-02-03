package com.lzhlyle.leetcode.week.no221;

public class MaximalSquare_DP {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

        int xl = matrix.length, yl = matrix[0].length;
        int[][] dp = new int[xl + 1][yl + 1];
        int max = 0;
        for (int i = 0; i < xl; i++) {
            for (int j = 0; j < yl; j++) {
                if (matrix[i][j] == '0') continue;
                dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i + 1][j])) + 1;
                max = Math.max(max, dp[i + 1][j + 1]);
            }
        }
        return max * max;
    }
}
