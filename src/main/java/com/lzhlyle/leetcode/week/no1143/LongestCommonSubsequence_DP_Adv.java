package com.lzhlyle.leetcode.week.no1143;

public class LongestCommonSubsequence_DP_Adv {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] arr1 = text1.toCharArray(), arr2 = text2.toCharArray();
        int len1 = arr1.length, len2 = arr2.length;
        int[] dp = new int[len2 + 1]; // +""
        for (int i = 0; i < len1; i++) {
            int northwest = 0;
            for (int j = 0; j < len2; j++) {
                int next = dp[j + 1];
                if (arr1[i] == arr2[j]) dp[j + 1] = northwest + 1;
                else dp[j + 1] = Math.max(dp[j], dp[j + 1]);
                northwest = next;
            }
        }
        return dp[len2];
    }
}
