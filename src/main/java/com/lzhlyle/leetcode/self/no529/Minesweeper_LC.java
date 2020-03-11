package com.lzhlyle.leetcode.self.no529;

public class Minesweeper_LC {
    private int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
    private int[] dy = {-1, 1, 0, 1, -1, 0, 1, -1};
    private int m, n;

    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        int i = click[0], j = click[1];
        if (board[i][j] == 'M') board[i][j] = 'X';
        else dfs(board, i, j);
        return board;
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) return;
        if (board[i][j] != 'E') return;
        char cnt = '0';
        for (int di = 0; di < 8; di++) {
            int x = i + dx[di], y = j + dy[di];
            if (x < 0 || y < 0 || x >= m || y >= n) continue;
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
