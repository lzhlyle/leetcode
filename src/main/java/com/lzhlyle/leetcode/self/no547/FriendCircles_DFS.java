package com.lzhlyle.leetcode.self.no547;

public class FriendCircles_DFS {
    public int findCircleNum(int[][] M) {
        int n = M.length, count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(M, i, visited);
            }
        }
        return count;
    }

    private void dfs(int[][] M, int i, boolean[] visited) {
        int n = M.length;
        for (int j = 0; j < n; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, j, visited);
            }
        }
    }
}
