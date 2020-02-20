package com.lzhlyle.leetcode.recite.no36;

public class ValidSudoku_Bit {
    public boolean isValidSudoku(char[][] board) {
        short[] row = new short[9], col = new short[9], box = new short[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int num = c - '1';
                if (((row[i] >> num) & 1) == 1) return false;
                else row[i] |= 1 << num;
                if (((col[j] >> num) & 1) == 1) return false;
                else col[j] |= 1 << num;
                int bi = (i / 3) * 3 + (j / 3);
                if (((box[bi] >> num) & 1) == 1) return false;
                else box[bi] |= 1 << num;
            }
        }
        return true;
    }
}
