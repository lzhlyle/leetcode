package com.lzhlyle.leetcode.week.no980;

public class UniquePathsIii {
    private int count = 0, rows, cols, empty = 2;
    private int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    public int uniquePathsIII(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int x = -1, y = -1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    x = r;
                    y = c;
                } else if (grid[r][c] == 0) empty++;
            }
        }
        if (x == -1) return 0;
        bt(grid, x, y, 1);
        return count;
    }

    private void bt(int[][] grid, int i, int j, int step) {
        if (grid[i][j] == 2) {
            if (step == empty) count++;
            return;
        }
        grid[i][j] = -1; // flood-fill
        for (int di = 0; di < 4; di++) {
            int x = i + dx[di], y = j + dy[di];
            if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] != -1) {
                bt(grid, x, y, step + 1);
            }
        }
        grid[i][j] = 0; // back tracking
    }
}
