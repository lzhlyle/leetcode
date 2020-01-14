package com.lzhlyle.leetcode.self.no64;

public class MinimumPathSum_Repeat {
    public int minPathSum(int[][] grid) {
        int rowCnt = grid.length;
        int colCnt = grid[0].length;
        for (int row = rowCnt - 2; row >= 0; row--) grid[row][colCnt - 1] += grid[row + 1][colCnt - 1];
        for (int col = colCnt - 2; col >= 0; col--) grid[rowCnt - 1][col] += grid[rowCnt - 1][col + 1];
        for (int row = rowCnt - 2; row >= 0; row--) {
            for (int col = colCnt - 2; col >= 0; col--) {
                grid[row][col] += Math.min(grid[row + 1][col], grid[row][col + 1]);
            }
        }
        return grid[0][0];
    }
}
