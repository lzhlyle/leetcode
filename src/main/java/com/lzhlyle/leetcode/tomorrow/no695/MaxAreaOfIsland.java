package com.lzhlyle.leetcode.tomorrow.no695;

public class MaxAreaOfIsland {
    private int rows, cols, max = 0;
    private int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        int area = 1;
        for (int di = 0; di < 4; di++) {
            int x = i + dx[di], y = j + dy[di];
            if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                area += dfs(grid, x, y);
            }
        }
        return area;
    }
}
