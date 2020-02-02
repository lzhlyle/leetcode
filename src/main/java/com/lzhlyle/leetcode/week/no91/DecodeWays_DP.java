package com.lzhlyle.leetcode.week.no91;

public class DecodeWays_DP {
    public int numDecodings(String s) {
        if (s == null || s.length() < 1 || s.startsWith("0")) return 0;

        char[] arr = s.toCharArray();
        int length = arr.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0; // 不独立解析
        dp[0][1] = 1; // 独立解析

        for (int i = 1; i < length; i++) {
            if (arr[i - 1] > '0' && (arr[i - 1] - '0') * 10 + (arr[i] - '0') < 27) dp[i][0] = dp[i - 1][1];
            if (arr[i] > '0') dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
        }

        return dp[length - 1][0] + dp[length - 1][1];
    }
}
