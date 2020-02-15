package com.lzhlyle.leetcode.self.no322;

import java.util.Arrays;

public class CoinChange_Greedy_DFS {
    private int min = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins); // greedy, larger first
        _backTracking(coins, coins.length - 1, amount, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    // dfs
    private void _backTracking(int[] coins, int ci, int rest, int cnt) {
        if (ci < 0) return;
        for (int i = rest / coins[ci]; i > -1; i--) {
            int currRest = rest - i * coins[ci];
            int currCnt = cnt + i;
            if (currRest > 0 && currCnt + 1 < min) _backTracking(coins, ci - 1, currRest, currCnt);
            else {
                if (currRest == 0) min = Math.min(min, currCnt);
                break;
            }
        }
    }
}
