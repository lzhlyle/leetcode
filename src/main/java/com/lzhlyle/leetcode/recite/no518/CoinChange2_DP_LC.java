package com.lzhlyle.leetcode.recite.no518;

public class CoinChange2_DP_LC {
    public int change(int amount, int[] coins) {
        int len = coins.length;

        int[][] dp = new int[len + 1][amount + 1]; // len + 1: 补充第一行"无硬币"时, amount + 1: 补充第一列"零金额"时
        dp[0][0] = 1; // 虽然无硬币，但刚好要求凑零金额，也算 1 种情况
        // 0 种与其说无法凑出，不如理解为"无法交代"， > 0 种表示有得交代，此处 1 理解为只有 1 种可交代的结果

        for (int ci = 0; ci < len; ci++) { // 从第一个硬币(ci==0)，即第二行(dp[ci+1])开始
            for (int money = 0; money <= amount; money++) {
                if (money < coins[ci]) dp[ci + 1][money] = dp[ci][money]; // 小于硬币值的，都不受影响
                else dp[ci + 1][money] = dp[ci][money] + dp[ci + 1][money - coins[ci]];
                //                        不用这枚硬币               用这枚硬币
                //                   =之前没有这枚硬币的情况      =总金额少掉这枚硬币的情况
            }
        }

        return dp[len][amount];
    }

    public static void main(String[] args) {
        int res = new CoinChange2_DP_LC().change(11, new int[]{2, 5, 10});
        System.out.println(res);
    }
}
