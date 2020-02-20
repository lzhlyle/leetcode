package com.lzhlyle.leetcode.recite.no547;

public class FriendCircles_DFS {
    public int findCircleNum(int[][] M) {
        int n = M.length, count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(M, i, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int i, boolean[] visited) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, j, visited);
            }
        }
    }
}
