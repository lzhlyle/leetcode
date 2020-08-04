package com.lzhlyle.leetcode.week.no1025;

public class DivisorGame_DP {
    public boolean divisorGame(int n) {
        if (n == 1) return false;
        boolean[] dp = new boolean[n + 1];
        dp[2] = true;
        for (int i = 3; i <= n; i++)
            for (int j = 1; j < i && !dp[i]; j++) // !dp[i] pruning
                dp[i] = i % j == 0 && !dp[i - j];
        return dp[n];
    }
}
