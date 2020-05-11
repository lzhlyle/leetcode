package com.lzhlyle.leetcode.recite.no997;

public class FindTheTownJudge_Degree {
    public int findJudge(int N, int[][] trust) {
        int[] degree = new int[N + 1]; // 出入度汇总累计
        for (int[] t : trust) {
            degree[t[0]]--;
            degree[t[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (degree[i] == N - 1) return i;
        }
        return -1;
    }
}
