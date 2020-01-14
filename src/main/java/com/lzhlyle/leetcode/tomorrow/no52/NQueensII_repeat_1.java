package com.lzhlyle.leetcode.tomorrow.no52;

public class NQueensII_repeat_1 {
    private int count = 0;
    private int size;

    public int totalNQueens(int n) {
        size = (1 << n) - 1;
        _locate(0b0, 0b0, 0b0);
        return count;
    }

    private void _locate(int row, int ld, int rd) {
        if (row >= size) {
            count++;
            return;
        }

        int possible = size & (~(row | ld | rd));
        while (possible != 0b0) {
            int position = possible & (-possible);
            possible &= possible - 1;

            _locate(row | position, (ld | position) << 1, (rd | position) >> 1);
        }
    }
}
