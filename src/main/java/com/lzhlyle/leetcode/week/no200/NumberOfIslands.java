package com.lzhlyle.leetcode.week.no200;

public class NumberOfIslands {
    private int[] dx = new int[]{-1, 0, 1, 0};
    private int[] dy = new int[]{0, 1, 0, -1};
    private int xl, yl;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) return 0;

        xl = grid.length;
        yl = grid[0].length;
        int count = 0;
        for (int i = 0; i < xl; i++) {
            for (int j = 0; j < yl; j++) {
                if (grid[i][j] == '0') continue;

                _floodfill(grid, i, j);
                ++count;
            }
        }
        return count;
    }

    private void _floodfill(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        for (int d = 0; d < 4; d++) {
            int x = dx[d], y = dy[d];
            if (i + x < 0 || i + x > xl - 1 || j + y < 0 || j + y > yl - 1) continue;
            if (grid[i + x][j + y] == '0') continue;
            _floodfill(grid, i + x, j + y);
        }
    }
}
