package com.lzhlyle.leetcode.tomorrow.no63;

public class UniquePathsII_DP_LC {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int cols = obstacleGrid[0].length;
        int[] dp = new int[cols];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int c = 0; c < cols; c++) {
                if (row[c] == 1) dp[c] = 0;
                else if (c > 0) dp[c] += dp[c - 1];
            }
        }
        return dp[cols - 1];
    }
}
