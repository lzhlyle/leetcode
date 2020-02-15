package com.lzhlyle.leetcode.recite.no1143;

public class LongestCommonSubsequence_DP {
    public int longestCommonSubsequence(String text1, String text2) {
        int lenI = text1.length(), lenJ = text2.length();
        int[][] dp = new int[lenI + 1][lenJ + 1];
        for (int i = 1; i <= lenI; i++) {
            for (int j = 1; j <= lenJ; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[lenI][lenJ];
    }
}
