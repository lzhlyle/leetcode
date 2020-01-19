package com.lzhlyle.leetcode.recite.no1091;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix_DoubleBFS_Loop_Top1 {
    class Cell {
        int x;
        int y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static final int[][] direc = new int[][]{{1, 0}, {-1, 0}, {1, 1}, {-1, 1}, {0, 1}, {1, -1}, {-1, -1}, {0, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        // base condition
        final int N = grid.length;
        if (N < 1 || grid[0][0] == 1 || grid[N - 1][N - 1] == 1) return -1;
        if (N == 1) return 1;

        Queue<Cell> beginQueue = new LinkedList<>();
        beginQueue.add(new Cell(0, 0));
        Queue<Cell> endQueue = new LinkedList<>();
        endQueue.add(new Cell(N - 1, N - 1));

        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;
        visited[N - 1][N - 1] = true;

        boolean[][] startVisited = new boolean[N][N];
        startVisited[0][0] = true;
        boolean[][] endVisited = new boolean[N][N];
        endVisited[N - 1][N - 1] = true;

        int step = 1;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            step++;
            if (beginQueue.size() > endQueue.size()) {
                Queue<Cell> swapQueue = beginQueue;
                beginQueue = endQueue;
                endQueue = swapQueue;

                boolean[][] swapVisited = startVisited;
                startVisited = endVisited;
                endVisited = swapVisited;
            }


            Queue<Cell> nextBeginQueue = new LinkedList<>();
            while (!beginQueue.isEmpty()) {
                Cell begin = beginQueue.remove();
                int x = begin.x, y = begin.y;
                for (int[] pos : direc) {
                    int i = x + pos[0], j = y + pos[1];
                    if (i >= 0 && i < N && j >= 0 && j < N && grid[i][j] == 0) {
                        Cell neighbor = new Cell(i, j);
                        if (endVisited[neighbor.x][neighbor.y]) return step;
                        if (visited[neighbor.x][neighbor.y]) continue;

                        nextBeginQueue.add(neighbor);
                        visited[neighbor.x][neighbor.y] = true;
                        startVisited[neighbor.x][neighbor.y] = true;
                    }
                }
            }
            beginQueue = nextBeginQueue;
        }
        return -1;
    }
}
