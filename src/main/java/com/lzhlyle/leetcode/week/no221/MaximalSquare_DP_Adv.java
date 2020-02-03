package com.lzhlyle.leetcode.week.no221;

public class MaximalSquare_DP_Adv {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

        int xl = matrix.length, yl = matrix[0].length;
        int[] dp = new int[yl + 2];
        int max = 0;

        for (int i = 0; i < xl; i++) {
            for (int j = 0; j < yl; j++) {
                int corner = dp[j + 1];
                if (matrix[i][j] == '1') {
                    dp[j + 1] = Math.min(dp[j], Math.min(dp[j + 1], dp[yl + 1])) + 1;
                    max = Math.max(max, dp[j + 1]);
                } else {
                    dp[j + 1] = 0; // reverse
                }
                // push dp
                dp[yl + 1] = corner; // last one is always corner
            }
        }

        return max * max;
    }
}
