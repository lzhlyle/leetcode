package com.lzhlyle.leetcode.self.lcci0107;

public class RotateMatrixLcci_IJ_RowReverse {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
         // i <-> j
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int swap = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = swap;
            }
        }

        // reverse each row
        for (int[] row : matrix) {
            int l = 0, r = n - 1;
            while (l < r) {
                int swap = row[l];
                row[l++] = row[r];
                row[r--] = swap;
            }
        }
    }
}
