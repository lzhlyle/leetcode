package com.lzhlyle.leetcode.recite.no980;

public class UniquePathsIii {
    private int count = 0, empty = 2, rows, cols;
    private int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    public int uniquePathsIII(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int x = 0, y = 0;
        rows = grid.length;
        cols = grid[0].length;
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
        dfs(grid, x, y, visited, 1);
        return count;

    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited, int step) {
        if (grid[i][j] == 2) {
            if (step == empty) count++;
            return;
        }

        // process
        visited[i][j] = true;

        // drill down
        for (int di = 0; di < 4; di++) {
            int x = i + dx[di], y = j + dy[di];
            if (x < 0 || x >= rows || y < 0 || y >= cols) continue;
            if (grid[x][y] == -1 || visited[x][y]) continue;
            dfs(grid, x, y, visited, step + 1);
        }

        // back tracking
        visited[i][j] = false;
    }
}
