package com.lzhlyle.leetcode.recite.no997;

public class FindTheTownJudge_LinkTb {
    // 邻接表
    public int findJudge(int N, int[][] trust) {
        boolean[][] tb = new boolean[N + 1][N + 1];
        for (int[] row : trust) {
            tb[row[0]][row[1]] = true;
        }
        for (int i = 1; i <= N; i++) {
            boolean isJudge = true;
            for (int j = 1; isJudge && j <= N; j++) {
                if (i == j) continue;
                if (tb[i][j] || !tb[j][i]) isJudge = false;
            }
            if (isJudge) return i;
        }
        return -1;
    }
}
