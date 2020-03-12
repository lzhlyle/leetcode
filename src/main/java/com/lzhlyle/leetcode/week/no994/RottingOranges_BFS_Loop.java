package com.lzhlyle.leetcode.week.no994;

public class RottingOranges_BFS_Loop {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean rotting = false;
        int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] != 2) continue;
                grid[r][c] = 0; // flood-fill
                for (int di = 0; di < 4; di++) {
                    int i = r + dx[di], j = c + dy[di];
                    if (i >= 0 && i < rows && j >= 0 && j < cols && grid[i][j] == 1) {
                        grid[i][j] = -1; // rotting
                        rotting = true;
                    }
                }
            }
        }

        if (!rotting) {
            for (int[] row : grid) for (int o : row) if (o == 1) return -1;
            return 0;
        }

        for (int[] row : grid) {
            for (int c = 0; c < cols; c++) {
                if (row[c] == -1) row[c] = 2;
            }
        }

        int res = orangesRotting(grid);
        return res == -1 ? -1 : res + 1;
    }
}
