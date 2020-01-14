package com.lzhlyle.leetcode.tomorrow.no51;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    private List<List<String>> result;
    private int boardSize;

    public List<List<String>> solveNQueens(int n) {
        boardSize = (1 << n) - 1;
        result = new ArrayList<>();
        _locate(0, 0b0, 0b0, 0b0, new int[n]);
        return result;
    }

    private void _locate(int level, int row, int leftDown, int rightDown, int[] playout) {
        if (row == boardSize) {
            result.add(_display(playout));
            return;
        }

        int possible = boardSize & (~(row | leftDown | rightDown));
        while (possible != 0) {
            int position = possible & (-possible);
            possible &= possible - 1;
            playout[level] = position;

            _locate(level + 1,
                    row | position,
                    (leftDown | position) << 1,
                    (rightDown | position) >> 1,
                    playout);
        }
    }

    private List<String> _display(int[] playout) {
        List<String> res = new ArrayList<>();
        int cols = playout.length;
        for (int row : playout) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < cols; i++) {
                builder.append((row >> i & 1) == 1 ? 'Q' : '.');
            }
            res.add(builder.toString());
        }
        return res;
    }
}
