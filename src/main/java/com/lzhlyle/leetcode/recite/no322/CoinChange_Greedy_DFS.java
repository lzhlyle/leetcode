package com.lzhlyle.leetcode.recite.no322;

import java.util.Arrays;

public class CoinChange_Greedy_DFS {
    private int min = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        _backTracking(coins, coins.length - 1, amount, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void _backTracking(int[] coins, int coinIndex, int amount, int cnt) {
        if (coinIndex < 0) return;
        for (int i = amount / coins[coinIndex]; i >= 0; i--) {
            int rest = amount - i * coins[coinIndex];
            int currCnt = cnt + i;
            if (rest > 0 && currCnt + 1 < min) _backTracking(coins, coinIndex - 1, rest, currCnt);
            else {
                if (rest == 0) min = Math.min(min, currCnt);
                break;
            }
        }
    }
}
