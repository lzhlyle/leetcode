package com.lzhlyle.leetcode.self.no1035;

public class UncrossedLines_DP {
    // 同最长公共子序列 1143
    public int maxUncrossedLines(int[] A, int[] B) {
        int a = A.length, b = B.length;
        int[] dp = new int[b + 1];
        for (int v : A) {
            int northwest = 0;
            for (int j = 0; j < b; j++) {
                int next = dp[j + 1];
                if (v == B[j]) dp[j + 1] = northwest + 1;
                else dp[j + 1] = Math.max(dp[j], dp[j + 1]);
                northwest = next;
            }
        }
        return dp[b];
    }
}
