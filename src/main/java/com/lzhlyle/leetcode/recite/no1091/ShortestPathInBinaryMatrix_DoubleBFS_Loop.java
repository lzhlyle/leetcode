package com.lzhlyle.leetcode.recite.no1091;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInBinaryMatrix_DoubleBFS_Loop {
    // two-ended bfs
    public int shortestPathBinaryMatrix(int[][] grid) {
        // base condition
        int n = grid.length - 1;
        if (grid[0][0] == 1 || grid[n][n] == 1) return -1;
        if (grid.length == 1) return 1;

        Queue<Cell> beginQueue = new LinkedList<>(Collections.singleton(new Cell(0, 0)));
        boolean[][] beginVisited = new boolean[n + 1][n + 1];
        beginVisited[0][0] = true;

        Queue<Cell> endQueue = new LinkedList<>(Collections.singleton(new Cell(n, n)));
        boolean[][] endVisited = new boolean[n + 1][n + 1];
        endVisited[n][n] = true;

        int step = 1;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            step++;
            if (beginQueue.size() > endQueue.size()) {
                Queue<Cell> swap = beginQueue;
                beginQueue = endQueue;
                endQueue = swap;

                boolean[][] swapVisited = beginVisited;
                beginVisited = endVisited;
                endVisited = swapVisited;
            }

            Queue<Cell> nextBeginQueue = new LinkedList<>();
            boolean[][] nextBeginVisited = new boolean[n + 1][n + 1];
            while (!beginQueue.isEmpty()) {
                Cell begin = beginQueue.remove();
                // flood-fill
                grid[begin.x][begin.y] = 1;
                // each neighbors
                for (Cell neighbor : _getNeighbors(begin.x, begin.y, grid, n + 1)) {
                    if (endVisited[neighbor.x][neighbor.y]) return step; // meet
                    if (grid[neighbor.x][neighbor.y] == 1) continue;
                    grid[neighbor.x][neighbor.y] = 1; // flood-fill

                    nextBeginQueue.add(neighbor);
                    nextBeginVisited[neighbor.x][neighbor.y] = true;
                }
            }

            beginQueue = nextBeginQueue;
            beginVisited = nextBeginVisited;
        }

        return -1;
    }

    // directions
    private static final int[] dx = new int[]{0, 0, -1, 1, -1, -1, 1, 1};
    private static final int[] dy = new int[]{1, -1, 0, 0, 1, -1, 1, -1};

    private static final int[][] direc = new int[][]{{1, 0}, {-1, 0}, {1, 1}, {-1, 1}, {0, 1}, {1, -1}, {-1, -1}, {0, -1}};

    private List<Cell> _getNeighbors(int x, int y, int[][] grid, int N) {
        List<Cell> res = new LinkedList<>();
        for (int i = 0; i < dx.length; i++) {
            if (x + dx[i] > grid.length - 1 || x + dx[i] < 0
                    || y + dy[i] > grid[0].length - 1 || y + dy[i] < 0) continue;
            res.add(new Cell(x + dx[i], y + dy[i]));
        }
//        for (int[] pos : direc) {
//            int new_i = x + pos[0], new_j = y + pos[1];
//            if (new_i >= 0 && new_i < N && new_j >= 0 && new_j < N && grid[new_i][new_j] == 0) {
//                res.add(new Cell(new_i, new_j));
//            }
//        }
        return res;
    }

    class Cell {
        int x;
        int y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
