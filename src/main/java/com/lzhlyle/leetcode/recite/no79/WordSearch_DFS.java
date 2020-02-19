package com.lzhlyle.leetcode.recite.no79;

public class WordSearch_DFS {
    private static final int[] _DIRECX = new int[]{-1, 0, 1, 0}, _DIRECY = new int[]{0, -1, 0, 1};

    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                boolean[][] visited = new boolean[rows][cols];
                visited[r][c] = true;
                if (_search(board, r, c, word, 0, visited)) return true;
            }
        }
        return false;
    }

    private boolean _search(char[][] board, int r, int c, String word, int chi, boolean[][] visited) {
        if (chi == word.length()) return true;

        char start = board[r][c];
        if (start != word.charAt(chi)) return false;
        if (chi == word.length() - 1) return true; // 已匹配完
        int rows = board.length, cols = board[0].length;
        for (int i = 0; i < 4; i++) {
            int x = _DIRECX[i], y = _DIRECY[i];
            if (r + x < 0 || r + x > rows - 1 || c + y < 0 || c + y > cols - 1 || visited[r + x][c + y]) continue;
            visited[r + x][c + y] = true;
            if (_search(board, r + x, c + y, word, chi + 1, visited)) return true;
            visited[r + x][c + y] = false; // reverse state for back tracking
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'a', 'b'}, {'c', 'd'}};
        String word = "cdba";
        boolean res = new WordSearch_DFS().exist(board, word);
        System.out.println(res);
    }
}
