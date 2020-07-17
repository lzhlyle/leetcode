package com.lzhlyle.leetcode.recite.lcof46;

public class BaShuZiFanYiChengZiFuChuanLcof_DP {
    public int translateNum(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int n = arr.length;
        int[] dp = new int[n + 1]; // +'0'
        dp[0] = dp[1] = 1;

        int prev = arr[0] - '0';
        for (int i = 1; i < n; i++) {
            dp[i + 1] = dp[i]; // at least

            int d = arr[i] - '0';
            if (prev > 0 && prev * 10 + d < 26) dp[i + 1] += dp[i - 1];
            prev = d;
        }
        return dp[n];
    }
}
