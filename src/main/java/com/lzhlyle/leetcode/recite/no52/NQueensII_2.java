package com.lzhlyle.leetcode.recite.no52;

public class NQueensII_2 {
    public int totalNQueens(int n) {
        // base condition
        if (n <= 0) return 0;
        if (n == 1) return 1;

        // initial
        int[] queensCol = new int[n];
        int visitedCol = 0, visitedUphill = 0, visitedDownhill = 0;

        // dfs
        return this.locate(0, n, 0, queensCol, visitedCol, visitedUphill, visitedDownhill);
    }

    private int locate(int row, int n, int count, int[] queensCol,
                       int visitedCol, int visitedUphill, int visitedDownhill) {
        // terminator
        // each col
        for (int col = 0; col < n; col++) {
            // current position: (row, col)
            if (this.validate(row, col, n, visitedCol, visitedUphill, visitedDownhill)) {
                // process
                queensCol[row] = col;
                visitedCol |= 1 << col;
                visitedUphill |= 1 << (row + col);
                visitedDownhill |= 1 << (n - 1 + row - col);

                if (row == n - 1) count++;
                    // drill down
                else count = this.locate(row + 1, n, count, queensCol, visitedCol, visitedUphill, visitedDownhill);

                // reverse state
                queensCol[row] = 0;
                visitedCol &= ~(1 << col);
                visitedUphill &= ~(1 << (row + col));
                visitedDownhill &= ~(1 << (n - 1 + row - col));
            }
        }
        return count;
    }

    private boolean validate(int x, int y, int n,
                             int visitedCol, int visitedUphill, int visitedDownhill) {
        return (visitedCol >> y & 1)
                + (visitedUphill >> (x + y) & 1)
                + (visitedDownhill >> (n - 1 + x - y) & 1) == 0;
    }
}
