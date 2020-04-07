package com.lzhlyle.leetcode.recite.lcci0107;

public class RotateMatrixLcci_Swap {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i <= (n / 2) - 1; i++) {
            for (int j = 0; j <= (n - 1) / 2; j++) {
                int swap = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = swap;
            }
        }
    }
}
