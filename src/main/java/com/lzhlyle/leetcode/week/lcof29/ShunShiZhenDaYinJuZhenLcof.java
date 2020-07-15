package com.lzhlyle.leetcode.week.lcof29;

public class ShunShiZhenDaYinJuZhenLcof {
    private static final int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    private int m, n;

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        m = matrix.length;
        n = matrix[0].length;

        int[] res = new int[m * n];
        print(res, 0, matrix, 0, 0, 0, new boolean[m][n]);
        return res;
    }

    private boolean print(int[] res, int ri, int[][] mat, int i, int j,
                          int di, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        if (visited[i][j]) return false;

        res[ri] = mat[i][j];
        visited[i][j] = true;

        int x = i + dx[di], y = j + dy[di];
        if (print(res, ri + 1, mat, x, y, di, visited)) return true;

        di = (di + 1) % 4;
        x = i + dx[di];
        y = j + dy[di];
        return print(res, ri + 1, mat, x, y, di, visited);
    }
}
