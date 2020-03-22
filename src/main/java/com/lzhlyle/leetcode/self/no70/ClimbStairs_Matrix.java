package com.lzhlyle.leetcode.self.no70;

public class ClimbStairs_Matrix {
    // O(log(n))
    public int climbStairs(int n) {
        if (n < 3) return n;
        int[][] mt = fib(n);
        return mt[0][0];
    }

    private static final int[][] _BASE = {{1, 1}, {1, 0}};

    private int[][] fib(int n) {
        if (n == 1) return _BASE;
        if ((n & 1) == 0) {
            int[][] mt = fib(n >> 1);
            return multi(mt, mt);
        }
        return multi(fib(n - 1), _BASE);
    }

    private int[][] multi(int[][] a, int[][] b) {
        int m = a.length, n = b[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = 0;
                for (int k = 0; k < a[0].length; k++) {
                    res[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return res;
    }
}
