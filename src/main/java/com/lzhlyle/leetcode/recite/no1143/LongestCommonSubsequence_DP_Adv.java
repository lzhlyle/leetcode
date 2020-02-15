package com.lzhlyle.leetcode.recite.no1143;

public class LongestCommonSubsequence_DP_Adv {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] arrI = text1.toCharArray(), arrJ = text2.toCharArray();
        int lenI = arrI.length, lenJ = arrJ.length;
        if (lenI == 0 || lenJ == 0) return 0;

        int[] dp = new int[lenJ + 1];
        int northwest;
        for (int i = 1; i <= lenI; i++) {
            northwest = 0;
            for (int j = 1; j <= lenJ; j++) {
                int nextNorthwest = dp[j];
                if (arrI[i - 1] == arrJ[j - 1]) dp[j] = northwest + 1;
                else if (dp[j] < dp[j - 1]) dp[j] = dp[j - 1];
                northwest = nextNorthwest;
            }
        }
        return dp[lenJ];
    }
}
