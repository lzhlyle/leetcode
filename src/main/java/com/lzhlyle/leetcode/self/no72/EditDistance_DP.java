package com.lzhlyle.leetcode.self.no72;

public class EditDistance_DP {
    public int minDistance(String word1, String word2) {
        char[] arr1 = word1.toCharArray(), arr2 = word2.toCharArray();
        int l1 = arr1.length, l2 = arr2.length;
        int[][] dp = new int[l1 + 1][l2 + 1]; // +""
        for (int i = 0; i <= l1; i++) dp[i][0] = i;
        for (int j = 0; j <= l2; j++) dp[0][j] = j;
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (arr1[i] == arr2[j]) dp[i + 1][j + 1] = dp[i][j];
                else dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
            }
        }
        return dp[l1][l2];
    }
}
