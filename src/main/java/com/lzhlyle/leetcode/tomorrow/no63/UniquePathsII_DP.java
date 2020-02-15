package com.lzhlyle.leetcode.tomorrow.no63;

public class UniquePathsII_DP {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            if (obstacleGrid[r][0] == 0) dp[r][0] = 1;
            else break;
        }
        for (int c = 0; c < cols; c++) {
            if (obstacleGrid[0][c] == 0) dp[0][c] = 1;
            else break;
        }
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (obstacleGrid[r][c] == 0) dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
