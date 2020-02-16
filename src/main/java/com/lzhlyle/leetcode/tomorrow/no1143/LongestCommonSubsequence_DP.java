package com.lzhlyle.leetcode.tomorrow.no1143;

public class LongestCommonSubsequence_DP {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] arrI = text1.toCharArray(), arrJ = text2.toCharArray();
        int lenI = arrI.length, lenJ = arrJ.length;
        if (lenI == 0 || lenJ == 0) return 0;

        int[][] dp = new int[lenI + 1][lenJ + 1]; // 补第一行、第一列的 "" 空子序列
        for (int i = 1; i <= lenI; i++) {
            for (int j = 1; j <= lenJ; j++) {
                if (arrI[i - 1] == arrJ[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[lenI][lenJ];
    }
}
