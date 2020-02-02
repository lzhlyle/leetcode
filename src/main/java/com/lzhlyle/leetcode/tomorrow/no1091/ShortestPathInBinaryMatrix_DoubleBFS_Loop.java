package com.lzhlyle.leetcode.tomorrow.no1091;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix_DoubleBFS_Loop {
    class Cell {
        int x, y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static final int[][] direc = new int[][]{{1, 0}, {-1, 0}, {1, 1}, {-1, 1}, {0, 1}, {1, -1}, {-1, -1}, {0, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        final int N = grid.length;
        if (N < 1 || grid[0][0] == 1 || grid[N - 1][N - 1] == 1) return -1;
        if (N == 1) return 1;

        Queue<Cell> beginQueue = new LinkedList<>(Collections.singleton(new Cell(0, 0)));
        Queue<Cell> endQueue = new LinkedList<>(Collections.singleton(new Cell(N - 1, N - 1)));

        boolean[][] visited = new boolean[N][N];
        visited[0][0] = visited[N - 1][N - 1] = true;

        boolean[][] beginVisited = new boolean[N][N];
        beginVisited[0][0] = true;

        boolean[][] endVisited = new boolean[N][N];
        endVisited[N - 1][N - 1] = true;

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
            while (!beginQueue.isEmpty()) {
                Cell begin = beginQueue.remove();

                for (int[] pos : direc) {
                    int i = begin.x + pos[0], j = begin.y + pos[1];
                    if (i >= 0 && i < N && j >= 0 && j < N && grid[i][j] == 0) {
                        if (endVisited[i][j]) return step;
                        if (visited[i][j]) continue;

                        visited[i][j] = true;
                        beginVisited[i][j] = true;
                        nextBeginQueue.add(new Cell(i, j));
                    }
                }
            }

            beginQueue = nextBeginQueue;
        }

        return -1;
    }
}
