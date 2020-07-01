package com.lzhlyle.leetcode.recite.no718;

public class MaximumLengthOfRepeatedSubarray_DP {
    public int findLength(int[] A, int[] B) {
        int n = B.length;
        int[] dp = new int[n + 1];
        int max = 0;
        for (int a : A) {
            int ori = 0;
            for (int j = 0; j < n; j++) {
                int next = dp[j + 1];
                if (a == B[j]) {
                    dp[j + 1] = ori + 1;
                    max = Math.max(max, dp[j + 1]);
                } else dp[j + 1] = 0;
                ori = next;
            }
        }
        return max;
    }
}
