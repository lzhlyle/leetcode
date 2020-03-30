package com.lzhlyle.leetcode.week.no70;

public class ClimbStairs_Matrix {
    private int[][] _BASE = {{1, 1}, {1, 0}};

    public int climbStairs(int n) {
        if (n < 2) return n;
        return fib(n)[0][0];
    }

    private int[][] fib(int n) {
        if (n == 1) return _BASE;
        if ((n & 1) == 0) {
            int[][] matrix = fib(n >> 1);
            return multi(matrix, matrix);
        }
        return multi(fib(n - 1), _BASE);
    }

    private int[][] multi(int[][] a, int[][] b) {
        int m = a.length, n = b[0].length, klen = b.length;
        int[][] c = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < klen; k++) {
                    sum += a[i][k] * b[k][j];
                }
                c[i][j] = sum;
            }
        }
        return c;
    }
}
