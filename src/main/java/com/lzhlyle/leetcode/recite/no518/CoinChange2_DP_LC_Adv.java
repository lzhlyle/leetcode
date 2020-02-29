package com.lzhlyle.leetcode.recite.no518;

public class CoinChange2_DP_LC_Adv {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int money = coin; money < amount + 1; money++) {
                dp[money] += dp[money - coin];
            }
        }

        return dp[amount];
    }
}
