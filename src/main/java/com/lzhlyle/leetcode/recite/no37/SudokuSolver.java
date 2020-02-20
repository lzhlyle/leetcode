package com.lzhlyle.leetcode.recite.no37;

public class SudokuSolver {
    private boolean[][] row = new boolean[9][9], col = new boolean[9][9], cube = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int num = c - '1';
                row[i][num] = true;
                col[j][num] = true;
                cube[(i / 3) * 3 + (j / 3)][num] = true;
            }
        }
        assign(board, 0);
    }

    private boolean assign(char[][] board, int cell) {
        if (cell == 81) return true;
        int i = cell / 9, j = cell % 9;

        if (board[i][j] != '.') return assign(board, cell + 1);

        // 开始放为 . 的
        for (int k = 0; k < 9; k++) { // 逐个尝试
            if (row[i][k] || col[j][k] || cube[(i / 3) * 3 + (j / 3)][k]) continue; // 此位无可能的数字

            // process
            board[i][j] = (char) (k + '1');
            row[i][k] = true;
            col[j][k] = true;
            cube[(i / 3) * 3 + (j / 3)][k] = true;

            // drill down
            if (assign(board, cell + 1)) return true;

            // back tracking
            board[i][j] = '.';
            row[i][k] = false;
            col[j][k] = false;
            cube[(i / 3) * 3 + (j / 3)][k] = false;
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new SudokuSolver().solveSudoku(board);
        System.out.println(board);
    }
}
