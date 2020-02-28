package com.lzhlyle.leetcode.week.no547;

public class FriendCircles_DFS {
    public int findCircleNum(int[][] M) {
        int n = M.length, count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            count++;
            _friends(M, i, visited);
        }
        return count;
    }

    private void _friends(int[][] M, int i, boolean[] visited) {
        for (int j = 0; j < M.length; j++) {
            if (visited[j]) continue;
            if (M[i][j] == 1) {
                visited[j] = true;
                _friends(M, j, visited);
            }
        }
    }
}
