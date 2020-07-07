package com.lzhlyle.leetcode.recite.no463;

public class IslandPerimeter_DFS {
    private static final int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1)
                    return calc(grid, i, j, new boolean[m][n]);
        return 0;
    }

    private int calc(int[][] mat, int i, int j, boolean[][] visited) {
        if (visited[i][j]) return 0;
        if (mat[i][j] == 0) return 1;
        int m = mat.length, n = mat[0].length;

        visited[i][j] = true;
        int res = 0;
        for (int di = 0; di < 4; di++) {
            int x = i + dx[di], y = j + dy[di];
            if (x < 0 || x >= m || y < 0 || y >= n) res += 1;
            else res += calc(mat, x, y, visited);
        }
        return res;
    }
}
