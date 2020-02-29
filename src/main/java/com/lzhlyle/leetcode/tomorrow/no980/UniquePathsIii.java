package com.lzhlyle.leetcode.tomorrow.no980;

public class UniquePathsIii {
    private int count = 0, empty = 2, rows, cols;
    private int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    public int uniquePathsIII(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int x = -1, y = -1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) empty++;
                else if (grid[r][c] == 1) {
                    x = r;
                    y = c;
                }
            }
        }
        if (x == -1) return 0;
        dfs(grid, x, y, 1);
        return count;
    }

    private void dfs(int[][] grid, int i, int j, int step) {
        if (grid[i][j] == 2) {
            if (step == empty) count++;
            return;
        }
        // flood-fill
        grid[i][j] = -1;
        for (int di = 0; di < 4; di++) {
            int x = i + dx[di], y = j + dy[di];
            if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] != -1) {
                dfs(grid, x, y, step + 1);
            }
        }
        grid[i][j] = 0;
    }
}
