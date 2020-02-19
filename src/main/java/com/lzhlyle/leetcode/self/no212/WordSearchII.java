package com.lzhlyle.leetcode.self.no212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
    char[][] board;
    boolean[][] visited;
    int[] dx = new int[]{-1, 0, 1, 0}, dy = new int[]{0, -1, 0, 1};

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.visited = new boolean[board.length][board[0].length];

        Trie trie = new Trie();
        for (String word : words) trie.insert(word);

        Set<String> res = new HashSet<>();
        int rows = board.length, cols = board[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                String curr = String.valueOf(board[r][c]);
                if (trie.startsWith(curr)) {
                    visited[r][c] = true;
                    dfs(r, c, curr, trie, res);
                    visited[r][c] = false;
                }
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(int x, int y, String curr, Trie trie, Set<String> res) {
        if (trie.search(curr)) res.add(curr); // 不可return，要继续找，可能存在同前缀的
        int rows = board.length, cols = board[0].length;
        for (int i = 0; i < 4; i++) {
            int xx = dx[i], yy = dy[i];
            if (x + xx >= 0 && x + xx < rows && y + yy >= 0 && y + yy < cols && !visited[x + xx][y + yy]) {
                String newCurr = curr + board[x + xx][y + yy];
                if (!trie.startsWith(newCurr)) continue;
                visited[x + xx][y + yy] = true;
                dfs(x + xx, y + yy, newCurr, trie, res);
                visited[x + xx][y + yy] = false;
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'a', 'b'}, {'a', 'a'}};
        List<String> res = new WordSearchII().findWords(board, new String[]{"aaab", "aaa"});
        System.out.println(res);
    }
}
