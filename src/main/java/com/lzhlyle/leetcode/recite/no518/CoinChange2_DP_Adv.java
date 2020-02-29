package com.lzhlyle.leetcode.recite.no518;

public class CoinChange2_DP_Adv {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        if (len == 0) {
            if (amount == 0) return 1;
            return 0;
        }

        int[][] dp = new int[len][amount + 1];
        dp[0][0] = 1;

        for (int coin = coins[0]; coin <= amount; coin += coins[0]) dp[0][coin] = 1;

        for (int coinIndex = 1; coinIndex < len; coinIndex++) {
            for (int money = 0; money <= amount; money++) {
                dp[coinIndex][money] = dp[coinIndex - 1][money];
                if (money - coins[coinIndex] >= 0) {
                    dp[coinIndex][money] += dp[coinIndex][money - coins[coinIndex]];
                }
            }
        }

        return dp[len - 1][amount];
    }
}
