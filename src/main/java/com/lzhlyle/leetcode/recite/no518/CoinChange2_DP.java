package com.lzhlyle.leetcode.recite.no518;

public class CoinChange2_DP {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        if (len == 0) {
            // 没有硬币
            if (amount == 0) return 1; // 也不需要凑，则 1 种 []
            return 0; // 组成其他元
        }

        int[][] dp = new int[len][amount + 1];
        dp[0][0] = 1;
        for (int coin = coins[0]; coin <= amount; coin += coins[0]) dp[0][coin] = 1; // 只有一个硬币，刚好组成 i 元的情况都是 1 种

        for (int coinIndex = 1; coinIndex < len; coinIndex++) {
            for (int money = 0; money < amount + 1; money++) {
                for (int coinCnt = 0; money - coinCnt * coins[coinIndex] >= 0; coinCnt++) {
                    dp[coinIndex][money] += dp[coinIndex - 1][money - coinCnt * coins[coinIndex]];
                }
            }
        }

        return dp[len - 1][amount];
    }
}
