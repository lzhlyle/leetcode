package com.lzhlyle.leetcode.recite.no52;

public class NQueensII {
    public int totalNQueens(int n) {
        // base condition
        if (n <= 0) return 0;
        if (n == 1) return 1;

        // initial
        int[] queensCol = new int[n];
        int[] visitedCol = new int[n];
        int[] visitedUphill = new int[2 * n - 1]; // x + y
        int[] visitedDownhill = new int[2 * n - 1]; // n - 1 + x - y

        // dfs
        return this.locate(0, n, 0, queensCol, visitedCol, visitedUphill, visitedDownhill);
    }

    private int locate(int row, int n, int count, int[] queensCol,
                       int[] visitedCol, int[] visitedUphill, int[] visitedDownhill) {
        // terminator
        // each col
        for (int col = 0; col < n; col++) {
            // current position: (row, col)
            if (this.validate(row, col, n, visitedCol, visitedUphill, visitedDownhill)) {
                // process
                queensCol[row] = col;
                visitedCol[col] = 1;
                visitedUphill[row + col] = 1;
                visitedDownhill[n - 1 + row - col] = 1;

                if (row == n - 1) count++;
                    // drill down
                else count = this.locate(row + 1, n, count, queensCol, visitedCol, visitedUphill, visitedDownhill);

                // reverse state
                queensCol[row] = 0;
                visitedCol[col] = 0;
                visitedUphill[row + col] = 0;
                visitedDownhill[n - 1 + row - col] = 0;
            }
        }
        return count;
    }

    private boolean validate(int x, int y, int n,
                             int[] visitedCol, int[] visitedUphill, int[] visitedDownhill) {
        return visitedCol[y] + visitedUphill[x + y] + visitedDownhill[n - 1 + x - y] == 0;
    }
}
