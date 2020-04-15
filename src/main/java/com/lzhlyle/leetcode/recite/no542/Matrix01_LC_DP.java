package com.lzhlyle.leetcode.recite.no542;

import java.util.Arrays;

public class Matrix01_LC_DP {
    // dp
    // O(mn)
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];
        for (int[] row : res) Arrays.fill(row, 10000);

        // initial 0
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == 0) res[i][j] = 0;

        // top-down
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) res[i][j] = Math.min(res[i][j], res[i - 1][j] + 1);
                if (j - 1 >= 0) res[i][j] = Math.min(res[i][j], res[i][j - 1] + 1);
            }
        }

        // bottom-up
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m) res[i][j] = Math.min(res[i][j], res[i + 1][j] + 1);
                if (j + 1 < n) res[i][j] = Math.min(res[i][j], res[i][j + 1] + 1);
            }
        }

        return res;
    }
}
