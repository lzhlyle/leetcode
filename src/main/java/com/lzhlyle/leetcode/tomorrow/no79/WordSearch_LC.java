package com.lzhlyle.leetcode.tomorrow.no79;

public class WordSearch_LC {

    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        char ch0 = word.charAt(0);
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == ch0) {
                    visited[r][c] = true;
                    if (dfs(board, r, c, word, 1, visited)) return true;
                    visited[r][c] = false;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int wi, boolean[][] visited) {
        if (wi == word.length()) return true;
        int rows = board.length, cols = board[0].length;
        int[][] delta = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        char ch = word.charAt(wi);
        for (int di = 0; di < 4; di++) {
            int dx = delta[di][0], x = i + dx, dy = delta[di][1], y = j + dy;
            if (x >= 0 && x < rows && y >= 0 && y < cols &&
                    !visited[x][y] && board[x][y] == ch) {
                visited[x][y] = true;
                if (dfs(board, x, y, word, wi + 1, visited)) return true;
                visited[x][y] = false;
            }
        }
        return false;
    }
}
