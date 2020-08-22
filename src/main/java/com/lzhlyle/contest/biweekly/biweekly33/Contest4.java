package com.lzhlyle.contest.biweekly.biweekly33;

public class Contest4 {
    // O(mn)
    private static final int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    private char[][] mat;
    private int m, n;
    private int[][] visited;

    public boolean containsCycle(char[][] grid) {
        mat = grid;
        m = mat.length;
        n = mat[0].length;
        visited = new int[m][n];
        if (m == 1 || n == 1) return false;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (dfs(i, j, 1)) return true;
        return false;
    }

    private boolean dfs(int i, int j, int dis) {
        // System.out.println(String.format("(%s, %s), dis: %s, mat[i][j]: %s", i, j, dis, mat[i][j]));
        if (visited[i][j] > 0) return dis - visited[i][j] > 2;
        visited[i][j] = dis;
        for (int di = 0; di < 4; di++) {
            int x = i + dx[di], y = j + dy[di];
            if (x >= 0 && x < m && y >= 0 && y < n)
                if (mat[x][y] == mat[i][j])
                    if (dfs(x, y, dis + 1)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {

        }
    }
}
