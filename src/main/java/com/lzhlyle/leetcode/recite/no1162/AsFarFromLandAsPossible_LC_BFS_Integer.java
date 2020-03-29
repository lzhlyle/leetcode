package com.lzhlyle.leetcode.recite.no1162;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible_LC_BFS_Integer {
    private int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    // bfs
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) queue.add(i * n + j);
            }
        }
        if (queue.isEmpty() || queue.size() == n * n) return -1;

        int far = -1;
        while (!queue.isEmpty()) {
            far++;
            Queue<Integer> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                int node = queue.remove();
                for (int di = 0; di < 4; di++) {
                    int x = (node / n) + dx[di], y = (node % n) + dy[di];
                    if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0) {
                        next.add(x * n + y);
                        grid[x][y] = 2; // flood-fill
                    }
                }
            }
            queue = next;
        }
        return far;
    }
}
