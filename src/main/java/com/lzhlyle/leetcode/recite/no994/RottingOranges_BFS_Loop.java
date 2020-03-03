package com.lzhlyle.leetcode.recite.no994;

public class RottingOranges_BFS_Loop {
    public int orangesRotting(int[][] grid) {
        int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1}; // 四连通
        boolean rotting = false; // 是否发生腐烂
        int rows = grid.length, cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) continue;
                if (grid[i][j] == 2) {
                    grid[i][j] = 0; // 烂过可以丢了: flood-fill
                    for (int di = 0; di < 4; di++) {
                        int x = i + dx[di], y = j + dy[di];
                        if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                            grid[x][y] = -1; // rotting... 腐烂中
                            rotting = true;
                        }
                    }
                }
            }
        }

        if (!rotting) { // 无腐烂现象
            // 是否还有好的
            for (int[] row : grid) {
                for (int o : row) {
                    if (o == 1) return -1;
                }
            }

            // 没有好的了
            return 0;
        }

        // 腐烂
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == -1) grid[i][j] = 2;
            }
        }

        // 递归
        int seconds = orangesRotting(grid);

        return seconds == -1 ? -1 : seconds + 1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0}};
        int res = new RottingOranges_BFS_Loop().orangesRotting(grid);
        System.out.println(res);
    }
}
