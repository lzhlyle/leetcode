package com.lzhlyle.leetcode.tomorrow.no5;

public class LongestPalindromicSubstring_DP {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length, begin = 0, mlen = 1;
        if (len < 2) return s;

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) dp[i][i] = true;

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (arr[i] == arr[j]) {
                    if (j - i < 3) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j] && j - i + 1 > mlen) {
                    mlen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + mlen);
    }
}
