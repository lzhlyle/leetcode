package com.lzhlyle.leetcode.recite.no200;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands_2 {
    // bfs
    public int numIslands(char[][] grid) {
        // base condition
        if (grid.length <= 0 || grid[0].length <= 0) return 0;

        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        // traversal
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (!visited[row][col] && grid[row][col] == '1') {
                    count++;
                    this._sinkDown(grid, row, col, visited);
                }
            }
        }

        return count;
    }

    // bfs
    private void _sinkDown(char[][] grid, int row, int col, boolean[][] visited) {
        Queue<SinkingLand> sinkQueue = new LinkedList<>();
        sinkQueue.add(new SinkingLand(row, col));
        visited[row][col] = true;

        // recursion
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // terminator
        while (!sinkQueue.isEmpty()) {
            // process
            SinkingLand land = sinkQueue.remove();
            grid[land.row][land.col] = '0';

            // drill down
            for (int[] direction : directions) {
                int newRow = land.row + direction[0];
                int newCol = land.col + direction[1];
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[land.row].length) {
                    // enqueue
                    if (!visited[newRow][newCol] && grid[newRow][newCol] == '1') {
                        sinkQueue.add(new SinkingLand(newRow, newCol));
                        visited[newRow][newCol] = true;
                    }
                }
            }
        }

        // reverse state
    }

    public class SinkingLand {
        int row;
        int col;

        SinkingLand(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int res = new NumberOfIslands_2().numIslands(grid);
        System.out.println(res);
    }
}
