package com.lzhlyle.leetcode.recite.no32;

public class LongestValidParentheses_DP_Recite {
    // dp
    // O(n)
    public int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length, max = 0;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (arr[i] == ')') {
                if (arr[i - 1] == '(') dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2; // ()()
                else if (i - dp[i - 1] - 1 >= 0 && arr[i - dp[i - 1] - 1] == '(') { // ..(())
                    int prev = i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0;
                    dp[i] = dp[i - 1] + prev + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int res = new LongestValidParentheses_DP_Recite().longestValidParentheses("()");
        System.out.println(res);

    }
}
