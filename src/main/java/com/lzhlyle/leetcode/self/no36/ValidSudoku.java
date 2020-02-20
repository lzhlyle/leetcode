package com.lzhlyle.leetcode.self.no36;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9], col = new boolean[9][9], cube = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                if (row[i][c - '1']) return false;
                else row[i][c - '1'] = true;
                if (col[j][c - '1']) return false;
                else col[j][c - '1'] = true;
                int ci = (i / 3) * 3 + (j / 3);
                if (cube[ci][c - '1']) return false;
                else cube[ci][c - '1'] = true;
            }
        }
        return true;
    }
}
