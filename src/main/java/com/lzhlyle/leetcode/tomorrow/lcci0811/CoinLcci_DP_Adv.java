package com.lzhlyle.leetcode.tomorrow.lcci0811;

public class CoinLcci_DP_Adv {
    private static final int _MOD = 1000000007;

    public int waysToChange(int n) {
        int[] coins = {1, 5, 10, 25};
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int money = coin; money <= n; money++) {
                dp[money] += dp[money - coin];
            }
        }
        return (int) (dp[n] % _MOD);
    }
}
