package com.lzhlyle.leetcode.recite.no289;

public class GameOfLife {
    private int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}, dy = {0, -1, 1, -1, 1, 0, -1, 1};

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;

        // -1: 0->1, 2: 1->0
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int di = 0; di < 8; di++) {
                    int x = i + dx[di], y = j + dy[di];
                    if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] > 0) cnt++;
                }
                if (board[i][j] == 1) {
                    if (cnt < 2 || cnt > 3) board[i][j] = 2; // 1->0
                } else if (cnt == 3) {
                    board[i][j] = -1; // 0->1
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) board[i][j] = 1;
                else if (board[i][j] == 2) board[i][j] = 0;
            }
        }
    }
}
