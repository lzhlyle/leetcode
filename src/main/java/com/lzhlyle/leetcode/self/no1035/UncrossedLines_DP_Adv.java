package com.lzhlyle.leetcode.self.no1035;

public class UncrossedLines_DP_Adv {
    // 同最长公共子序列 1143
    public int maxUncrossedLines(int[] A, int[] B) {
        int a = A.length, b = B.length;
        int[][] dp = new int[a + 1][b + 1];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (A[i] == B[j]) dp[i + 1][j + 1] = dp[i][j] + 1;
                else dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[a][b];
    }
}
