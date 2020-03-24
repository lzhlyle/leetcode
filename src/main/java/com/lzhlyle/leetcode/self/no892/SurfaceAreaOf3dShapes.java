package com.lzhlyle.leetcode.self.no892;

public class SurfaceAreaOf3dShapes {
    public int surfaceArea(int[][] grid) {
        int n = grid.length, res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int h = grid[i][j];
                if (h > 0) {
                    res += 4 * h + 2;
                    if (i > 0 && grid[i - 1][j] > 0) res -= Math.min(h, grid[i - 1][j]) * 2;
                    if (j > 0 && grid[i][j - 1] > 0) res -= Math.min(h, grid[i][j - 1]) * 2;
                }
            }
        }
        return res;
    }
}
