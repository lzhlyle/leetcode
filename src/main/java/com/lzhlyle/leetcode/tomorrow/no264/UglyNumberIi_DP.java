package com.lzhlyle.leetcode.tomorrow.no264;

public class UglyNumberIi_DP {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n]; // the i-th ugly number
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0; // last index
        for (int i = 1; i < n; i++) {
            int u2 = dp[i2] * 2, u3 = dp[i3] * 3, u5 = dp[i5] * 5;
            dp[i] = Math.min(Math.min(u2, u3), u5);
            if (dp[i] == u2) i2++;
            if (dp[i] == u3) i3++;
            if (dp[i] == u5) i5++;
        }
        return dp[n - 1];
    }
}
