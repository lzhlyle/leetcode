package com.lzhlyle.leetcode.week.no733;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill_BFS {
    private static final int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    private int m, n;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int target = image[sr][sc];
        if (target == newColor) return image;
        m = image.length;
        n = image[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] p = queue.remove();
            for (int di = 0; di < 4; di++) {
                int x = p[0] + dx[di], y = p[1] + dy[di];
                if (x >= 0 && x < m && y >= 0 && y < n)
                    if (image[x][y] == target) {
                        queue.add(new int[]{x, y});
                        image[x][y] = newColor;
                    }
            }
        }
        return image;
    }
}
