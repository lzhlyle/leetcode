package com.lzhlyle.leetcode.recite.no70;

public class ClimbStairs_Matrix_Recite {
    // O(log(n))
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[][] res = fib(n);
        return res[0][0];
    }

    private static final int[][] UNIT = {{1, 1}, {1, 0}};

    private int[][] fib(int n) {
        if (n == 1) return UNIT;
        if ((n & 1) == 0) {
            int[][] matrix = fib(n >> 1);
            return multi(matrix, matrix);
        }
        return multi(fib(n - 1), UNIT);
    }

    private int[][] multi(int[][] A, int[][] B) {
        int m = A.length, n = B[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = 0;
                for (int k = 0; k < A[0].length; k++) {
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return res;
    }
}
