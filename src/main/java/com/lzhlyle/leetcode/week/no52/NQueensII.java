package com.lzhlyle.leetcode.week.no52;

public class NQueensII {
    private int count = 0;

    public int totalNQueens(int n) {
        _locate((1 << n) - 1, 0b0, 0b0, 0b0);
        return count;
    }

    private void _locate(int size, int row, int ld, int rd) {
        if (row == size) {
            count++;
            return;
        }

        int possible = size & (~(row | ld | rd));
        while (possible != 0) {
            int position = possible & (-possible);
            possible &= possible - 1;

            _locate(size, row | position, (ld | position) << 1, (rd | position) >> 1);
        }
    }
}
