package com.lzhlyle.leetcode.recite.no892;

public class SurfaceAreaOf3dShapes {
    private int[] dx = {1, 0}, dy = {0, -1};

    public int surfaceArea(int[][] grid) {
        int n = grid.length, res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int h = grid[i][j];
                if (h == 0) continue;

                grid[i][j] = 0; // flood-fill
                res += 4 * h + 2; // all surface

                // ths situation around: only need to dfs right and down, because of flood-fill
                for (int di = 0; di < 2; di++) {
                    int x = i + dx[di], y = j + dy[di];
                    if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] > 0) {
                        res -= Math.min(h, grid[x][y]) * 2;
                    }
                }
            }
        }
        return res;
    }
}
