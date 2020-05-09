package com.lzhlyle.leetcode.tomorrow.lcof13;

public class JiQiRenDeYunDongFanWeiLcof_DFS_LC {
    private int cnt;

    public int movingCount(int m, int n, int k) {
        cnt = 0;
        dfs(m, n, 0, 0, 0, k, new boolean[m][n]);
        return cnt;
    }

    private void dfs(int m, int n, int i, int j, int v, int k, boolean[][] visited) {
        if (i == m || j == n || visited[i][j] || v > k) return;
        cnt++;
        visited[i][j] = true;
        dfs(m, n, i + 1, j, next(i + 1, v), k, visited);
        dfs(m, n, i, j + 1, next(j + 1, v), k, visited);
    }

    private int next(int num, int v) {
        return num % 10 == 0 ? v - 8 : v + 1;
    }
}
