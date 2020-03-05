package com.lzhlyle.leetcode.tomorrow.no994;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges_BFS_While {
    private int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1}; // 四连通

    public int orangesRotting(int[][] grid) {
        Queue<Orange> queue = new LinkedList<>();
        int rows = grid.length, cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) queue.add(new Orange(i, j));
            }
        }

        int second = -1;
        while (!queue.isEmpty()) {
            second++;
            Queue<Orange> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                Orange bad = queue.remove();
                grid[bad.x][bad.y] = 0; // flood-fill
                for (int di = 0; di < 4; di++) {
                    int x = bad.x + dx[di], y = bad.y + dy[di];
                    if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                        grid[x][y] = 2; // visited
                        next.add(new Orange(x, y));
                    }
                }
            }
            queue = next;
        }
        for (int[] row : grid) for (int o : row) if (o == 1) return -1;
        return second == -1 ? 0 : second;
    }

    class Orange {
        int x, y;

        public Orange(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
