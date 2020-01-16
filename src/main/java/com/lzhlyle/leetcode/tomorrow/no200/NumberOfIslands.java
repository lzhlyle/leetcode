package com.lzhlyle.leetcode.tomorrow.no200;

public class NumberOfIslands {
    // dfs
    private final int[] dx = new int[]{-1, 0, 1, 0};
    private final int[] dy = new int[]{0, -1, 0, 1};
    private int xl, yl;

    public int numIslands(char[][] grid) {
        if (grid.length < 1 || grid[0].length < 1) return 0;

        this.xl = grid.length;
        this.yl = grid[0].length;
        int count = 0;
        for (int i = 0; i < xl; i++) {
            for (int j = 0; j < yl; j++) {
                if (grid[i][j] == '1') {
                    _floodFill(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void _floodFill(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        for (int k = 0; k < dx.length; k++) {
            int x = dx[k], y = dy[k];
            if (i + x < 0 || j + y < 0 || i + x > xl - 1 || j + y > yl - 1) continue;
            if (grid[i + x][j + y] == '0') continue;
            grid[i + x][j + y] = '0';
            _floodFill(grid, i + x, j + y);
        }
    }
}
