package com.lzhlyle.leetcode.week.no36;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9], col = new boolean[9][9], cube = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int chi = c - '1', ci = (i / 3) * 3 + (j / 3);
                if (row[i][chi] || col[j][chi] || cube[ci][chi]) return false;
                row[i][chi] = col[j][chi] = cube[ci][chi] = true;
            }
        }
        return true;
    }
}
