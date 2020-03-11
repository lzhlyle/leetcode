package com.lzhlyle.leetcode.recite.no529;

import java.util.ArrayList;
import java.util.List;

public class Minesweeper {
    private int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
    private int[] dy = {1, -1, 0, 1, -1, 0, 1, -1};
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
//        print(board);
        List<int[]> next = new ArrayList<>(8);
        char cnt = '0';
        for (int di = 0; di < 8; di++) {
            int x = i + dx[di], y = j + dy[di];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (board[x][y] == 'M') cnt++;
                else if (board[x][y] == 'E') next.add(new int[]{x, y});
            }
        }
        if (cnt > '0') board[i][j] = cnt;
        else {
            board[i][j] = 'B';
            for (int[] neighbor : next) dfs(board, neighbor[0], neighbor[1]);
        }
    }

    private void print(char[][] board) {
        for (char[] row : board) {
            StringBuilder builder = new StringBuilder();
            for (char c : row) builder.append(c).append("\t");
            System.out.println(builder.toString());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[][] board = {{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3, 0};
        char[][] res = new Minesweeper().updateBoard(board, click);
        System.out.println(res);
    }
}
