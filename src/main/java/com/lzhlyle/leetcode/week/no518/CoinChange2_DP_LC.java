package com.lzhlyle.leetcode.week.no518;

public class CoinChange2_DP_LC {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        dp[0][0] = 1;
        for (int ci = 0; ci < len; ci++) {
            for (int money = 0; money <= amount; money++) {
                if (money < coins[ci]) dp[ci + 1][money] = dp[ci][money];
                else dp[ci + 1][money] = dp[ci][money] + dp[ci + 1][money - coins[ci]];
            }
        }
        return dp[len][amount];
    }
}
