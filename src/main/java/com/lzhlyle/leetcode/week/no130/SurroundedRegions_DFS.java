package com.lzhlyle.leetcode.week.no130;

public class SurroundedRegions_DFS {
    private int m, n;
    private int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][n - 1] == 'O') dfs(board, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[m - 1][j] == 'O') dfs(board, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        board[i][j] = '#';
        for (int di = 0; di < 4; di++) {
            int x = i + dx[di], y = j + dy[di];
            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
                dfs(board, x, y);
            }
        }
    }
}
