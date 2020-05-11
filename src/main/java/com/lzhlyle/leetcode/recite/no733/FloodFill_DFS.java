package com.lzhlyle.leetcode.recite.no733;

public class FloodFill_DFS {
    private static final int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    private int m, n;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        m = image.length;
        n = image[0].length;
        dfs(image, sr, sc, image[sr][sc], newColor, new boolean[m][n]);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int from, int to, boolean[][] visited) {
        if (image[i][j] != from || visited[i][j]) return;
        visited[i][j] = true;
        image[i][j] = to;
        for (int di = 0; di < 4; di++) {
            int x = i + dx[di], y = j + dy[di];
            if (x >= 0 && x < m && y >= 0 && y < n)
                if (image[x][y] == from && !visited[x][y])
                    dfs(image, x, y, from, to, visited);
        }
    }
}
