package com.lzhlyle.leetcode.self.no887;

public class SuperEggDrop_DP_LC {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        int f = 0;
        while (dp[K][f] < N) {
            f++;
            for (int i = 1; i <= K; i++) {
                dp[i][f] = dp[i][f - 1] + dp[i - 1][f - 1] + 1;
            }
        }
        return f;
    }
}
