package com.lzhlyle.leetcode.week.no37;

public class SudokuSolver {
    boolean[][] row = new boolean[9][9], col = new boolean[9][9], cube = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        // set occupied
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int chi = c - '1', cbi = (i / 3) * 3 + (j / 3);
                row[i][chi] = col[j][chi] = cube[cbi][chi] = true;
            }
        }
        assign(board, 0);
    }

    private boolean assign(char[][] board, int cell) {
        if (cell == 81) return true;
        int i = cell / 9, j = cell % 9;
        char c = board[i][j];
        if (c != '.') return assign(board, cell + 1);

        // each num
        int cbi = (i / 3) * 3 + (j / 3);
        for (char num = '1'; num <= '9'; num++) {
            int chi = num - '1';
            if (row[i][chi] || col[j][chi] || cube[cbi][chi]) continue;

            board[i][j] = num;
            row[i][chi] = col[j][chi] = cube[cbi][chi] = true;

            if (assign(board, cell + 1)) return true;

            board[i][j] = '.';
            row[i][chi] = col[j][chi] = cube[cbi][chi] = false;
        }
        return false;
    }
}
