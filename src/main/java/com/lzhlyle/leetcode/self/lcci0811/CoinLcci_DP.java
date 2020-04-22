package com.lzhlyle.leetcode.self.lcci0811;

public class CoinLcci_DP {
    private static final int _MOD = 1000000007;

    public int waysToChange(int n) {
        int[] coins = {1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int money = coin; money <= n; money++) {
                dp[money] += dp[money - coin] % _MOD;
            }
        }
        return dp[n] % _MOD;
    }
}
