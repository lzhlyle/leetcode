package com.lzhlyle.leetcode.recite.no292;

public class NimGame_DP {
    public boolean canWinNim(int n) {
        if (n == 0) return false;
        if (n <= 3) return true;
        boolean[] dp = new boolean[n + 1];
        dp[1] = dp[2] = dp[3] = true;
        for (int i = 4; i <= n; i++)
            if (dp[i - 4]) dp[i] = true;
        return dp[n];
    }
}
