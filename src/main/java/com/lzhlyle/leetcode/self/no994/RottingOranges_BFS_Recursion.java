package com.lzhlyle.leetcode.self.no994;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges_BFS_Recursion {
    private int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1}; // 四连通
    int rows, cols;

    public int orangesRotting(int[][] grid) {
        Queue<Orange> queue = new LinkedList<>();
        rows = grid.length;
        cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) queue.add(new Orange(i, j));
            }
        }

        int res = rotting(-1, grid, queue);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return res == -1 ? 0 : res;
    }

    private int rotting(int second, int[][] grid, Queue<Orange> queue) {
        if (queue.isEmpty()) return second;

        Queue<Orange> next = new LinkedList<>();
        while (!queue.isEmpty()) {
            Orange orange = queue.remove();
            for (int di = 0; di < 4; di++) {
                grid[orange.x][orange.y] = 0;
                int x = orange.x + dx[di], y = orange.y + dy[di];
                if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                    grid[x][y] = 2; // visited
                    next.add(new Orange(x, y));
                }
            }
        }

        return rotting(second + 1, grid, next);
    }

    class Orange {
        int x, y;

        public Orange(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0}};
        int res = new RottingOranges_BFS_Recursion().orangesRotting(grid);
        System.out.println(res);
    }
}
