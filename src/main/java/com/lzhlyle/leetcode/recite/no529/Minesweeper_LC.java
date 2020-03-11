package com.lzhlyle.leetcode.recite.no529;

public class Minesweeper_LC {
    private int[][] dir = new int[][]{{1, 0}, {1, -1}, {1, 1}, {0, 1}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}};
    private int m, n;

    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        int i = click[0], j = click[1];
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return board;
        }
        dfs(board, i, j);
        return board;
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) return;
        if (board[i][j] != 'E') return;
        int cnt = 0;
        for (int[] d : dir) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'M') cnt++;
        }
        if (cnt > 0) board[i][j] = (char) (cnt + '0');
        else {
            board[i][j] = 'B';
            for (int[] d : dir) dfs(board, i + d[0], j + d[1]);
        }
    }
}
