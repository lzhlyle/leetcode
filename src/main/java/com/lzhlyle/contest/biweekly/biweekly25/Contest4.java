package com.lzhlyle.contest.biweekly.biweekly25;

import java.util.Comparator;
import java.util.List;

public class Contest4 {
    // wrong
    // 数独??
    // greedy + dp
    private static final int _MOD = 1000000007;

    public int numberWays(List<List<Integer>> hats) {
        // 排序，先安排最挑食的
        hats.sort(Comparator.comparingInt(List::size));

        int n = hats.size(), sum = 0;
        long[][] dp = new long[n][40]; // i:人, j:已选的帽子, val:方案数
        List<Integer> firstLike = hats.get(0);
        for (int j = 0; j < firstLike.size(); j++) dp[0][firstLike.get(j) - 1] = 1;
        for (int i = 1; i < n; i++) {
            List<Integer> likes = hats.get(i);
            for (int j = 0; j < likes.size(); j++) {
                int h = likes.get(j) - 1;
                if (dp[i - 1][h] > 0) continue;
                dp[i][j] = dp[i - 1][h];
                sum += dp[i][h] % _MOD;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Contest4 contest = new Contest4();
        {

        }
    }
}
