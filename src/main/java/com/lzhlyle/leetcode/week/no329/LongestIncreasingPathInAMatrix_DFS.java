package com.lzhlyle.leetcode.week.no329;

public class LongestIncreasingPathInAMatrix_DFS {
    private static final int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    private int[][] mat;
    private int m, n, max;

    public int longestIncreasingPath(int[][] matrix) {
        mat = matrix;
        if ((m = mat.length) == 0 || (n = mat[0].length) == 0) return 0;
        max = 1;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (memo[i][j] == 0)
                    dfs(i, j, memo);
        return max;
    }

    private int dfs(int i, int j, int[][] memo) {
        if (memo[i][j] > 0) return memo[i][j];
        int curr = 0;
        for (int di = 0; di < 4; di++) {
            int x = i + dx[di], y = j + dy[di];
            if (x >= 0 && x < m && y >= 0 && y < n)
                if (mat[x][y] > mat[i][j])
                    curr = Math.max(curr, dfs(x, y, memo));
        }
        max = Math.max(max, curr + 1);
        return memo[i][j] = curr + 1;
    }
}
