package com.lzhlyle.leetcode.week.no994;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges_BFS_Recursion {
    private int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    private int rows, cols;

    public int orangesRotting(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        Queue<Orange> queue = new ArrayDeque<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) queue.add(new Orange(r, c));
            }
        }

        int res = rotting(-1, grid, queue);
        for (int[] row : grid) for (int o : row) if (o == 1) return -1;
        return res == -1 ? 0 : res;
    }

    private int rotting(int second, int[][] grid, Queue<Orange> queue) {
        if (queue.isEmpty()) return second;
        Queue<Orange> next = new ArrayDeque<>();
        for (Orange orange : queue) {
            grid[orange.x][orange.y] = 0; // flood-fill
            for (int di = 0; di < 4; di++) {
                int i = orange.x + dx[di], j = orange.y + dy[di];
                if (i >= 0 && i < rows && j >= 0 && j < cols && grid[i][j] == 1) {
                    grid[i][j] = 2; // visited
                    next.add(new Orange(i, j));
                }
            }
        }
        return rotting(second + 1, grid, next);
    }

    class Orange {
        int x, y;

        Orange(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
