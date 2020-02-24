package com.lzhlyle.leetcode.week.no1143;

public class LongestCommonSubsequence_DP {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] arr1 = text1.toCharArray(), arr2 = text2.toCharArray();
        int len1 = arr1.length, len2 = arr2.length;
        int[][] dp = new int[len1 + 1][len2 + 1]; // +""
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (arr1[i] == arr2[j]) dp[i + 1][j + 1] = dp[i][j] + 1;
                else dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[len1][len2];
    }
}
