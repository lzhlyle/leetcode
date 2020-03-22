package com.lzhlyle.leetcode.recite.no70;

public class ClimbStairs_Matrix {
    // O(log(n))
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[][] matrix = fib(n);
        return matrix[0][0];
    }

    private static final int[][] UNIT = {{1, 1}, {1, 0}};

    private int[][] fib(int n) {
        if (n == 1) return UNIT;
        // even
        if ((n & 1) == 0) {
            int[][] matrix = fib(n >> 1);
            return matrixMultiply(matrix, matrix);
        }
        // odd
        return matrixMultiply(fib(n - 1), UNIT);
    }

    private int[][] matrixMultiply(int[][] m, int[][] n) {
        int rows = m.length;
        int cols = n[0].length;
        int[][] res = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[i][j] = 0;
                for (int k = 0; k < m[i].length; k++) {
                    res[i][j] += m[i][k] * n[k][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ClimbStairs_Matrix solution = new ClimbStairs_Matrix();
        long begin = System.currentTimeMillis();
        for (int i = 1; i < 200000; i++) {
            solution.climbStairs(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
}
