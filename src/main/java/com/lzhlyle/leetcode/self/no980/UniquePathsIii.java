package com.lzhlyle.leetcode.self.no980;

public class UniquePathsIii {
    private int count = 0, empty = 2, rows, cols;
    private int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    public int uniquePathsIII(int[][] grid) {
        if ((rows = grid.length) == 0) return 0;
        if ((cols = grid[0].length) == 0) return 0;
        int x = -1, y = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) empty++;
                else if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }
        if (x == -1) return 0;
        dfs(1, grid, x, y);
        return count;
    }

    private void dfs(int step, int[][] grid, int i, int j) {
        if (grid[i][j] == 2) {
            if (step == empty) count++;
            return;
        }

        grid[i][j] = -1;
        for (int di = 0; di < 4; di++) {
            int x = i + dx[di], y = j + dy[di];
            if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] != -1) {
                dfs(step + 1, grid, x, y);
            }
        }
        grid[i][j] = 0;
    }
}
