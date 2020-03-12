package com.lzhlyle.leetcode.tomorrow.no529;

public class Minesweeper_LC {
    private int rows, cols;

    public char[][] updateBoard(char[][] board, int[] click) {
        rows = board.length;
        cols = board[0].length;
        int i = click[0], j = click[1];
        if (board[i][j] == 'M') board[i][j] = 'X';
        else dfs(board, i, j);
        return board;
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) return;
        if (board[i][j] != 'E') return;
        int[] dx = {0, 0, -1, -1, -1, 1, 1, 1};
        int[] dy = {-1, 1, 0, -1, 1, 0, -1, 1};
        char cnt = '0';
        for (int di = 0; di < 8; di++) {
            int x = i + dx[di], y = j + dy[di];
            if (x < 0 || x >= rows || y < 0 || y >= cols) continue;
            if (board[x][y] == 'M') ++cnt;
        }
        if (cnt > '0') board[i][j] = cnt;
        else {
            board[i][j] = 'B';
            for (int di = 0; di < 8; di++) {
                dfs(board, i + dx[di], j + dy[di]);
            }
        }
    }
}
