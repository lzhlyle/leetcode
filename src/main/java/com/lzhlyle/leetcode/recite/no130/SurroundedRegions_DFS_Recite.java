package com.lzhlyle.leetcode.recite.no130;

public class SurroundedRegions_DFS_Recite {
    private int m, n;
    private int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    public void solve(char[][] board) {
        m = board.length;
        if (m == 0) return;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean edge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (edge && board[i][j] == 'O') dfs(board, i, j);
            }
        }
        for (char[] row : board) {
            for (int j = 0; j < n; j++) {
                row[j] = row[j] == '#' ? 'O' : 'X';
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
