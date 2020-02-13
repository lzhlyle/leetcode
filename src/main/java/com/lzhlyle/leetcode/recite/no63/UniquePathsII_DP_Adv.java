package com.lzhlyle.leetcode.recite.no63;

public class UniquePathsII_DP_Adv {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        if (cols == 1) return (obstacleGrid[rows - 1][cols - 1] == 0 && obstacleGrid[0][0] == 0) ? 1 : 0;

        int[] dp = new int[cols];
        for (int c = 0; c < cols; c++) {
            if (obstacleGrid[0][c] == 0) dp[c] = 1;
            else break;
        }
        for (int r = 1; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (c == 0) {
                    if (obstacleGrid[r][c] == 1) dp[c] = 0;
                } else if (obstacleGrid[r][c] == 0) dp[c] += dp[c - 1];
                else dp[c] = 0;
            }
        }
        return dp[cols - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0}, {1}};
        int res = new UniquePathsII_DP_Adv().uniquePathsWithObstacles(grid);
        System.out.println(res);
    }
}
