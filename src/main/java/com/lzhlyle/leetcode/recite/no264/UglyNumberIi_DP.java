package com.lzhlyle.leetcode.recite.no264;

public class UglyNumberIi_DP {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1]; // the i-th ugly number
        dp[1] = 1;
        int i2 = 1, i3 = 1, i5 = 1; // last index
        for (int i = 2; i <= n; i++) {
            int dp2 = dp[i2] * 2, dp3 = dp[i3] * 3, dp5 = dp[i5] * 5;
            dp[i] = Math.min(Math.min(dp2, dp3), dp5);
            if (dp[i] == dp2) i2++;
            if (dp[i] == dp3) i3++;
            if (dp[i] == dp5) i5++;
        }
        return dp[n];
    }
}
