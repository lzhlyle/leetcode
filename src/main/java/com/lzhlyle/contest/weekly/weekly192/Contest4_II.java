package com.lzhlyle.contest.weekly.weekly192;

public class Contest4_II {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m][n + 1][target + 1]; // i:[0, m - 1], j:[1, n], t:[1, target], val:c
        for (int i = 0; i < m; i++)
            for (int j = 0; j <= n; j++)
                for (int t = 0; t <= target; t++)
                    dp[i][j][t] = -1; // 不可能

        if (houses[0] > 0) {
            // 已有颜色
            dp[0][houses[0]][1] = 0;
        } else {
            for (int j = 1; j <= n; j++) {
                dp[0][j][1] = cost[0][j - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                if (houses[i] > 0) {
                    // 已有颜色
                    for (int t = 1; t <= target; t++) {
                        dp[i][houses[i]][t] = dp[i - 1][j][houses[i] == j ? t : t - 1];
                    }
                } else {
                    for (int t = 1; t <= target; t++) {
                        if (houses[i - 1] > 0) {
                            // 前一个已有固定色
                            if (dp[i - 1][houses[i - 1]][t - 1] != -1)
                                dp[i][j][t] = dp[i - 1][houses[i - 1]][t - 1] + cost[i][j - 1];
                        } else dp[i][j][t] = dp[i - 1][j][t] + cost[i][j - 1];
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= n; j++)
            if (dp[m - 1][j][target] != -1)
                min = Math.min(min, dp[m - 1][j][target]);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        Contest4_II contest = new Contest4_II();
        {
            int[] houses = new int[]{0, 0, 0, 0, 0};
            int[][] cost = new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}};
            int m = 5, n = 2, target = 3;
            int res = contest.minCost(houses, cost, m, n, target);
            System.out.println(res);
        }
    }
}
