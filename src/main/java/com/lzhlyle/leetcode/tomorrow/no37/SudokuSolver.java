package com.lzhlyle.leetcode.tomorrow.no37;

public class SudokuSolver {
    private boolean[][] row = new boolean[9][9], col = new boolean[9][9], cube = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int chi = c - '1';
                row[i][chi] = col[j][chi] = cube[(i / 3) * 3 + (j / 3)][chi] = true;
            }
        }
        assign(board, 0);
    }

    private boolean assign(char[][] board, int cell) {
        if (cell == 81) return true;
        int i = cell / 9, j = cell % 9;
        if (board[i][j] != '.') return assign(board, cell + 1);

        for (int k = 0; k < 9; k++) {
            int cbi = (i / 3) * 3 + (j / 3);
            if (row[i][k] || col[j][k] || cube[cbi][k]) continue;

            board[i][j] = (char) (k + '1');
            row[i][k] = col[j][k] = cube[cbi][k] = true;

            if (assign(board, cell + 1)) return true;

            board[i][j] = '.';
            row[i][k] = col[j][k] = cube[cbi][k] = false;
        }

        return false;
    }
}
