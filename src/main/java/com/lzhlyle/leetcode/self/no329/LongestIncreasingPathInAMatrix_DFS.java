package com.lzhlyle.leetcode.self.no329;

public class LongestIncreasingPathInAMatrix_DFS {
    private static final int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    private int m, n;

    public int longestIncreasingPath(int[][] mat) {
        if (mat.length == 0 || mat[0].length == 0) return 0;
        m = mat.length;
        n = mat[0].length;
        int max = 1;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (memo[i][j] == 0)
                    max = Math.max(max, dfs(i, j, mat, memo));
        return max;
    }

    private int dfs(int i, int j, int[][] mat, int[][] memo) {
        if (memo[i][j] > 0) return memo[i][j];
        int max = 0;
        for (int di = 0; di < 4; di++) {
            int x = i + dx[di], y = j + dy[di];
            if (x >= 0 && x < m && y >= 0 && y < n)
                if (mat[x][y] > mat[i][j])
                    max = Math.max(max, dfs(x, y, mat, memo));
        }
        return memo[i][j] = max + 1;
    }
}
