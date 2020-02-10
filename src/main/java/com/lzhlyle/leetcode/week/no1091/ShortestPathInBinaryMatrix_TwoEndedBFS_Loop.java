package com.lzhlyle.leetcode.week.no1091;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix_TwoEndedBFS_Loop {
    private static final int[][] _DIRECTIONS = new int[][]{{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int len = grid.length;
        if (len == 0) return -1;
        if (grid[0][0] == 1 || grid[len - 1][len - 1] == 1) return -1;
        if (len == 1) return 1;

        Queue<Cell> beginQueue = new LinkedList<>(Collections.singleton(new Cell(0, 0)));
        Queue<Cell> endQueue = new LinkedList<>(Collections.singleton(new Cell(len - 1, len - 1)));

        boolean[][] visited = new boolean[len][len];
        visited[0][0] = visited[len - 1][len - 1] = true;
        boolean[][] beginVisited = new boolean[len][len];
        beginVisited[0][0] = true;
        boolean[][] endVisited = new boolean[len][len];
        endVisited[len - 1][len - 1] = true;

        int step = 1;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            if (beginQueue.size() > endQueue.size()) {
                Queue<Cell> swap = beginQueue;
                beginQueue = endQueue;
                endQueue = swap;

                boolean[][] swapVisited = beginVisited;
                beginVisited = endVisited;
                endVisited = swapVisited;
            }

            step++;
            Queue<Cell> nextBegin = new LinkedList<>();
            while (!beginQueue.isEmpty()) {
                Cell begin = beginQueue.remove();

                for (int[] direction : _DIRECTIONS) {
                    int x = begin.x + direction[0], y = begin.y + direction[1];
                    if (x >= 0 && x < len && y >= 0 && y < len && grid[x][y] == 0) {
                        if (endVisited[x][y]) return step;
                        if (visited[x][y]) continue;

                        visited[x][y] = true;
                        beginVisited[x][y] = true;
                        nextBegin.add(new Cell(x, y));
                    }
                }
            }
            beginQueue = nextBegin;
        }

        return -1;
    }

    class Cell {
        int x, y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        int res = new ShortestPathInBinaryMatrix_TwoEndedBFS_Loop().shortestPathBinaryMatrix(grid);
        System.out.println(res);
    }
}

