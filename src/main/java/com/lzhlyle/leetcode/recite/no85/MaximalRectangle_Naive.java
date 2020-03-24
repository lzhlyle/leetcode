package com.lzhlyle.leetcode.recite.no85;

public class MaximalRectangle_Naive {
    // naive
    // 枚举左上角、右下角
    // O(m*n*m*n)
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, max = 0;
        for (int i1 = 0; i1 < m; i1++) {
            for (int j1 = 0; j1 < n; j1++) {
                if (matrix[i1][j1] == '0') continue;
                int r = n; // r: 以 (i1, j1) 为左上角的、可到达的最右边界
                for (int i2 = i1; i2 < m; i2++) {
                    for (int j2 = j1; j2 < r; j2++) { // r 为边界
                        if (matrix[i2][j2] == '0') {
                            r = j2;
                            break;
                        }
                    }
                    // 此行到头了再计算
                    max = Math.max(max, (i2 - i1 + 1) * (r - 1 - j1 + 1));
                }
            }
        }
        return max;
    }
}
