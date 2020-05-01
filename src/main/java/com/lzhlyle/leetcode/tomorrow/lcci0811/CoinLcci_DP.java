package com.lzhlyle.leetcode.tomorrow.lcci0811;

public class CoinLcci_DP {
    private static final int _MOD = 1000000007;

    public int waysToChange(int n) {
        int[] coins = {1, 5, 10, 25};
        long[][] dp = new long[5][n + 1];
        dp[0][0] = 1;
        for (int ci = 0; ci < 4; ci++) {
            for (int money = 0; money <= n; money++) {
                if (money < coins[ci]) dp[ci + 1][money] = dp[ci][money];
                else dp[ci + 1][money] = dp[ci][money] + dp[ci + 1][money - coins[ci]];
            }
        }
        return (int) (dp[4][n] % _MOD);
    }
}
