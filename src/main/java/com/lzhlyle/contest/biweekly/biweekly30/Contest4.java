package com.lzhlyle.contest.biweekly.biweekly30;

import java.util.ArrayList;
import java.util.List;

public class Contest4 {
    public boolean winnerSquareGame(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++)
            list.add(i * i);
        int[] arr = new int[list.size()];
        int ai = 0;
        for (int sq : list) arr[ai++] = sq;

        boolean[] dp = new boolean[n + 1];
        dp[1] = true;
        for (int i = 1; i <= n; i++) {
            for (int sq : arr) {
                if (i - sq < 0) break;
                if (!dp[i - sq]) { // 你不行，我就行
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {

        }
    }
}
