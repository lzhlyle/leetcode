package com.lzhlyle.leetcode.week.no695;

public class MaxAreaOfIsland {
    private int m, n;
    private int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        int area = 1;
        for (int di = 0; di < 4; di++) {
            int x = i + dx[di], y = j + dy[di];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                area += dfs(grid, x, y);
            }
        }
        return area;
    }
}
