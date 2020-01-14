package com.lzhlyle.leetcode.tomorrow.no51;

import java.util.ArrayList;
import java.util.List;

public class NQueens_repeat_1 {
    private List<List<String>> result;
    private int size;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        size = (1 << n) - 1;
        _locate(0, 0b0, 0b0, 0b0, new int[n]);
        return result;
    }

    private void _locate(int level, int row, int ld, int rd, int[] playouts) {
        if (row >= size) {
            result.add(_display(playouts));
            return;
        }

        int possible = size & (~(row | ld | rd));
        while (possible != 0b0) {
            int position = possible & (-possible);
            possible &= possible - 1;
            playouts[level] = position;

            _locate(level + 1, row | position, (ld | position) << 1, (rd | position) >> 1, playouts);
        }
    }

    private List<String> _display(int[] playouts) {
        List<String> res = new ArrayList<>();
        int cols = playouts.length;
        for (int row : playouts) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < cols; i++) {
                builder.append((row >> i & 1) == 1 ? 'Q' : '.');
            }
            res.add(builder.toString());
        }
        return res;
    }
}
