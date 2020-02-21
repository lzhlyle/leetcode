package com.lzhlyle.leetcode.tomorrow.no36;

public class ValidSudoku_Bit {
    public boolean isValidSudoku(char[][] board) {
        short[] row = new short[9], col = new short[9], cube = new short[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;

                int chi = c - '1';

                if (((row[i] >> chi) & 1) == 1) return false;
                row[i] |= 1 << chi;

                if (((col[j] >> chi) & 1) == 1) return false;
                col[j] |= 1 << chi;

                int cbi = (i / 3) * 3 + (j / 3);
                if (((cube[cbi] >> chi) & 1) == 1) return false;
                cube[cbi] |= 1 << chi;
            }
        }
        return true;
    }
}
