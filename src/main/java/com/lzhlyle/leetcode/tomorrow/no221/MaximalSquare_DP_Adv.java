package com.lzhlyle.leetcode.tomorrow.no221;

public class MaximalSquare_DP_Adv {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length < 1 || matrix[0].length < 1) return 0;

        int x = matrix.length, y = matrix[0].length, max = 0;
        int[] dp = new int[y + 2]; // dp[0] always corner
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int corner = dp[j + 1];
                if (matrix[i][j] == '1') {
                    dp[j + 1] = Math.min(dp[j], Math.min(dp[j + 1], dp[y + 1])) + 1;
                    max = Math.max(max, dp[j + 1]);
                } else {
                    dp[j + 1] = 0;
                }
                // push dp
                dp[y + 1] = corner;
            }
        }
        return max * max;
    }
}
