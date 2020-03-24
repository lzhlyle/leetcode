package com.lzhlyle.leetcode.recite.no85;

public class MaximalRectangle_DP {
    // dp
    // O(m*n*(m + n))
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, max = 0;
        int[][] dpH = new int[m][n], dpW = new int[m][n]; // 以 (m, n) 为右下角的所有全1矩阵中的高/宽
        dpH[0][0] = dpW[0][0] = matrix[0][0] - '0'; // '0'则0，'1'则1
        max = Math.max(max, dpH[0][0]);
        for (int i = 1; i < m; i++) { // 首列
            dpH[i][0] = matrix[i][0] == '1' ? (dpH[i - 1][0] + 1) : 0;
            max = Math.max(max, dpH[i][0]);
            dpW[i][0] = matrix[i][0] - '0';
        }
        for (int j = 1; j < n; j++) { // 首列
            dpH[0][j] = matrix[0][j] - '0';
            dpW[0][j] = matrix[0][j] == '1' ? (dpW[0][j - 1] + 1) : 0;
            max = Math.max(max, dpW[0][j]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') dpH[i][j] = dpW[i][j] = 0;
                else {
                    int minH = dpH[i][j] = dpH[i - 1][j] + 1;
                    int minW = dpW[i][j] = dpW[i][j - 1] + 1;

                    for (int r = i; r > -1; r--) {
                        if (dpH[r][j] == 0) break;
                        minW = Math.min(minW, dpW[r][j]);
                        int area = (i - r + 1) * minW;
                        if (area > max) {
                            max = area;
                        }
                    }

                    for (int c = j; c > -1; c--) {
                        if (dpW[i][c] == 0) break;
                        minH = Math.min(minH, dpH[i][c]);
                        int area = minH * (j - c + 1);
                        if (area > max) {
                            max = area;
                        }
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] matrix = {{'1'}};
        int res = new MaximalRectangle_DP().maximalRectangle(matrix);
        System.out.println(res);
    }
}
