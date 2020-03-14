package com.lzhlyle.leetcode.recite.no695;

public class MaxAreaOfIsland {
    private int max = 0, rows, cols;
    private int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) max = Math.max(max, dfs(grid, r, c));
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        int area = 1;
        grid[i][j] = 0; // flood-fill
        for (int di = 0; di < 4; di++) {
            int x = i + dx[di], y = j + dy[di];
            if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                area += dfs(grid, x, y);
            }
        }
        return area;
    }
}
