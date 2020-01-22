package com.lzhlyle.leetcode.week.no64;

public class MinimumPathSum_DP {
    public int minPathSum(int[][] grid) {
        // initial
        int rows = grid.length, cols = grid[0].length;
        for (int r = rows - 2; r >= 0; r--) {
            grid[r][cols - 1] += grid[r + 1][cols - 1];
        }
        for (int c = cols - 2; c >= 0; c--) {
            grid[rows - 1][c] += grid[rows - 1][c + 1];
        }

        // dp bottom-up
        for (int r = rows - 2; r >= 0; r--) {
            for (int c = cols - 2; c >= 0; c--) {
                grid[r][c] += Math.min(grid[r + 1][c], grid[r][c + 1]);
            }
        }
        return grid[0][0];
    }
}
