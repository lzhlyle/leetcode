package com.lzhlyle.leetcode.tomorrow.no64;

public class MinimumPathSum_DP {
    public int minPathSum(int[][] grid) {
        int width = grid.length;
        int height = grid[0].length;
        for (int row = width - 2; row >= 0; row--) {
            grid[row][height - 1] += grid[row + 1][height - 1];
        }
        for (int col = height - 2; col >= 0; col--) {
            grid[width - 1][col] += grid[width - 1][col + 1];
        }
        for (int row = width - 2; row >= 0; row--) {
            for (int col = height - 2; col >= 0; col--) {
                grid[row][col] += Math.min(grid[row + 1][col], grid[row][col + 1]);
            }
        }
        return grid[0][0];
    }
}
