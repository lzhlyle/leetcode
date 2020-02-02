package com.lzhlyle.leetcode.week.no51;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<>();
        _locate(0, 0b0, 0b0, 0b0, new int[n], (1 << n) - 1, res);
        return res;
    }

    private void _locate(int level, int row, int ld, int rd, int[] curr, int size, List<List<String>> res) {
        if (row == size) {
            res.add(_display(curr));
            return;
        }

        int possible = size & (~(row | ld | rd));
        while (possible != 0) {
            int position = possible & (-possible);
            curr[level] = position;
            possible &= possible - 1;

            _locate(level + 1, row | position, (ld | position) << 1, (rd | position) >> 1,
                    curr, size, res);
        }
    }

    private List<String> _display(int[] curr) {
        int cols = curr.length;
        List<String> res = new ArrayList<>(cols);
        for (int row : curr) {
            StringBuilder builder = new StringBuilder();
            for (int c = 0; c < cols; c++) {
                builder.append((row >> c & 1) == 1 ? 'Q' : '.');
            }
            res.add(builder.toString());
        }
        return res;
    }
}
