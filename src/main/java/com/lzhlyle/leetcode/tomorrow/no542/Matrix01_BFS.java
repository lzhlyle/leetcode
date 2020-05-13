package com.lzhlyle.leetcode.tomorrow.no542;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01_BFS {
    // bfs
    // O(mn)

    private int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) queue.add(new int[]{i, j});
                else res[i][j] = -1;
            }
        }

        int lvl = 0;
        while (!queue.isEmpty()) {
            lvl++;
            Queue<int[]> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                int[] node = queue.remove();
                for (int di = 0; di < 4; di++) {
                    int x = node[0] + dx[di], y = node[1] + dy[di];
                    if (x >= 0 && x < m && y >= 0 && y < n && res[x][y] == -1) {
                        res[x][y] = lvl;
                        next.add(new int[]{x, y});
                    }
                }
            }
            queue = next;
        }

        return res;
    }
}
