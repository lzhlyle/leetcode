package com.lzhlyle.leetcode.recite.no36;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9], col = new int[9][9], box = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                if (row[i][c - '1'] != 0) return false;
                else row[i][c - '1']++;
                if (col[j][c - '1'] != 0) return false;
                else col[j][c - '1']++;
                int bi = (i / 3) * 3 + (j / 3);
                if (box[bi][c - '1'] != 0) return false;
                else box[bi][c - '1']++;
            }
        }
        return true;
    }
}
