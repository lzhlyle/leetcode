package com.lzhlyle.leetcode.recite.no518;

import java.util.Arrays;

public class CoinChange2 {
    private int count = 0;

    // TIMEOUT!
    public int change(int amount, int[] coins) {
        if (coins.length == 0 && amount == 0) return 1;
        Arrays.sort(coins);
        dfs(coins, coins.length - 1, amount);
        return count;
    }

    private void dfs(int[] coins, int ci, int rest) {
        if (ci < 0) return;
        for (int i = rest / coins[ci]; i >= 0; i--) {
            int currRest = rest - i * coins[ci];
            if (currRest == 0) count++;
            else if (currRest > 0) dfs(coins, ci - 1, currRest);
            else break;
        }
    }

    public static void main(String[] args) {
        int res = new CoinChange2().change(500, new int[]{3, 5, 7, 8, 9, 10, 11});
        System.out.println(res);
    }
}
