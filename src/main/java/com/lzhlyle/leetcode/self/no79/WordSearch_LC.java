package com.lzhlyle.leetcode.self.no79;

public class WordSearch_LC {
    char[][] board;
    boolean[][] visited;
    int[] dx = new int[]{-1, 0, 1, 0}, dy = new int[]{0, -1, 0, 1};

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (dfs(word, 1, i, j)) return true;
                    visited[i][j] = false;
                }
            }
        }
        return dfs(word, 0, 0, 0);
    }

    public boolean dfs(String word, int wi, int x, int y) {
        if (wi == word.length()) return true;
        int rows = board.length, cols = board[0].length;
        for (int i = 0; i < 4; i++) {
            int xx = dx[i], yy = dy[i];
            if (x + xx >= 0 && x + xx < rows && y + yy >= 0 && y + yy < cols &&
                    !visited[x + xx][y + yy] && board[x + xx][y + yy] == word.charAt(wi)) {
                visited[x + xx][y + yy] = true;
                if (dfs(word, wi + 1, x + xx, y + yy)) return true;
                visited[x + xx][y + yy] = false;
            }
        }
        return false;
    }
}
