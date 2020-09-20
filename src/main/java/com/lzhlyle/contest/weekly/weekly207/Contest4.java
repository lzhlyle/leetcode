package com.lzhlyle.contest.weekly.weekly207;

import java.util.Arrays;
import java.util.List;

public class Contest4 {
    public int connectTwoGroups(List<List<Integer>> cost) {
        int lCnt = cost.size(), rCnt = cost.get(0).size();
        final int MAX = (int) 1e9;

        int[][] dp = new int[lCnt + 1][1 << rCnt];
        for (int i = 0; i <= lCnt; i++)
            Arrays.fill(dp[i], MAX);
        dp[0][0] = 0;

        // 左侧
        for (int i = 0; i < lCnt; i++) {
            List<Integer> prices = cost.get(i);
            // 右侧
            for (int j = 0; j < rCnt; j++) {
                // 右侧所有连接情况
                for (int k = 0; k < 1 << rCnt; k++) {
                    int mask = k | (1 << j);
                    dp[i + 1][mask] = Math.min(dp[i + 1][mask], dp[i][k] + prices.get(j));
                }
            }
        }

        // 右侧最小成本
        int[] minCost = new int[rCnt];
        Arrays.fill(minCost, MAX);
        for (int j = 0; j < rCnt; j++)
            for (List<Integer> prices : cost)
                minCost[j] = Math.min(minCost[j], prices.get(j));

        int res = MAX;
        for (int k = 0; k < 1 << rCnt; k++) {
            int sum = dp[lCnt][k];
            int delta = ((1 << rCnt) - 1) - k;
            for (int j = 0; j < rCnt; j++)
                if ((delta & (1 << j)) != 0)
                    sum += minCost[j];
            res = Math.min(res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {

        }
    }
}
