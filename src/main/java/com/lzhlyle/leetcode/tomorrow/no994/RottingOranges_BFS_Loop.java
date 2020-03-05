package com.lzhlyle.leetcode.tomorrow.no994;

public class RottingOranges_BFS_Loop {
    public int orangesRotting(int[][] grid) {
        int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1}; // 四连通
        boolean rotting = false; // 是否发生腐烂
        int rows = grid.length, cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    grid[i][j] = 0; // flood-fill
                    for (int di = 0; di < 4; di++) {
                        int x = i + dx[di], y = j + dy[di];
                        if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                            grid[x][y] = -1; // rotting..
                            rotting = true;
                        }
                    }
                }
            }
        }

        if (!rotting) {
            for (int[] row : grid) for (int o : row) if (o == 1) return -1;
            return 0;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == -1) grid[i][j] = 2;
            }
        }

        int seconds = orangesRotting(grid);
        return seconds == -1 ? -1 : seconds + 1;
    }
}
