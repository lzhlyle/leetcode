package com.lzhlyle.leetcode.recite.lcof13;

public class JiQiRenDeYunDongFanWeiLcof_DFS {
    private int cnt = 0;

    public int movingCount(int m, int n, int k) {
        dfs(m, n, 0, 0, k, new boolean[m][n]);
        return cnt;
    }

    private void dfs(int m, int n, int i, int j, int k, boolean[][] visited) {
        if (i == m || j == n || visited[i][j]) return;
        if (valid(i, j, k)) cnt++;
        else return;
        visited[i][j] = true;
        dfs(m, n, i + 1, j, k, visited);
        dfs(m, n, i, j + 1, k, visited);
    }

    private boolean valid(int i, int j, int k) {
        int total = 0;
        while (i > 0) {
            total += i % 10;
            i /= 10;
        }
        while (j > 0) {
            total += j % 10;
            j /= 10;
        }
        return total <= k;
    }
}
