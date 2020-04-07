package com.lzhlyle.leetcode.self.lcci0107;

public class RotateMatrixLcci_ColReverse_IJ {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // reverse each col
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int swap = matrix[l][i];
                matrix[l++][i] = matrix[r][i];
                matrix[r--][i] = swap;
            }
        }

        // i <-> j
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int swap = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = swap;
            }
        }
    }
}
