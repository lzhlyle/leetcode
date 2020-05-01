package com.lzhlyle.leetcode.week.no32;

public class LongestValidParentheses_DP {
    // dp
    // O(n)
    public int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();
        int max = 0, len = arr.length;
        int[] dp = new int[len];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '(') continue;
            if (valid(arr, i - 1)) {
                // ..(..)()
                dp[i] = 2 + dp(dp, i - 2);
            } else if (valid(arr, i - dp[i - 1] - 1)) {
                // ..((..))
                int prev = dp(dp, i - dp[i - 1] - 2);
                dp[i] = prev + dp[i - 1] + 2;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private boolean valid(char[] arr, int i) {
        return i >= 0 && arr[i] == '(';
    }

    private int dp(int[] dp, int i) {
        return i >= 0 ? dp[i] : 0;
    }
}
