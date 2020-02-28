package com.lzhlyle.leetcode.recite.no980;

public class UniquePathsIii_Recite {
    private int count = 0, empty = 2, rows, cols;
    private int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    public int uniquePathsIII(int[][] grid) {
        rows = grid.length;
        if (rows < 1) return 0;
        cols = grid[0].length;
        if (cols < 1) return 0;

        int x = 0, y = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) empty++;
                else if (grid[r][c] == 1) {
                    x = r;
                    y = c;
                }
            }
        }
        boolean[][] visited = new boolean[rows][cols];
        dfs(1, grid, x, y, visited);
        return count;
    }

    private void dfs(int step, int[][] grid, int i, int j, boolean[][] visited) {
        if (grid[i][j] == 2) {
            if (step == empty) count++;
            return;
        }
        visited[i][j] = true;
        for (int di = 0; di < 4; di++) {
            int x = i + dx[di], y = j + dy[di];
            if (x >= 0 && x < rows && y >= 0 && y < cols &&
                    grid[x][y] != -1 && !visited[x][y]) {
                dfs(step + 1, grid, x, y, visited);
            }
        }
        visited[i][j] = false;
    }
}
