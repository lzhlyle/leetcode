package com.lzhlyle.leetcode.week.no322;

import java.util.Arrays;

public class CoinChange_Greedy_DFS {
    private int min = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins); // asc
        dfs(coins, coins.length - 1, amount, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void dfs(int[] coins, int ci, int rest, int cnt) {
        if (ci < 0) return;
        for (int i = rest / coins[ci]; i >= 0; i--) {
            int currRest = rest - i * coins[ci], currCnt = cnt + i;
            if (currRest > 0 && currCnt + 1 < min) dfs(coins, ci - 1, currRest, currCnt);
            else {
                if (currRest == 0 && currCnt < min) min = currCnt;
                break;
            }
        }
    }
}
