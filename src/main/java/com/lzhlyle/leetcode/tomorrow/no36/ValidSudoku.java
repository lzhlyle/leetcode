package com.lzhlyle.leetcode.tomorrow.no36;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9], col = new boolean[9][9], cube = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;

                int chi = c - '1';

                if (row[i][chi]) return false;
                row[i][chi] = true;

                if (col[j][chi]) return false;
                col[j][chi] = true;

                int cbi = (i / 3) * 3 + (j / 3);
                if (cube[cbi][chi]) return false;
                cube[cbi][chi] = true;
            }
        }
        return true;
    }
}
