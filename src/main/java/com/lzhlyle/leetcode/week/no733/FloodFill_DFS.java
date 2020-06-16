package com.lzhlyle.leetcode.week.no733;

public class FloodFill_DFS {
    private static final int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    private int m, n;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int from = image[sr][sc];
        if (from == newColor) return image;
        m = image.length;
        n = image[0].length;

        dfs(image, sr, sc, from, newColor);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int from, int to) {
        image[i][j] = to;
        for (int di = 0; di < 4; di++) {
            int x = i + dx[di], y = j + dy[di];
            if (x >= 0 && x < m && y >= 0 && y < n)
                if (image[x][y] == from)
                    dfs(image, x, y, from, to);
        }
    }
}
