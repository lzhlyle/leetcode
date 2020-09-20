package com.lzhlyle.contest.weekly.weekly207;

public class Contest3 {
    // dp
    private static final int MOD = (int) 1e9 + 7;

    public int maxProductPath(int[][] g) {
        int m = g.length, n = g[0].length;
        long[][][] dp = new long[m][n][2]; // 2: {min, max}
        dp[0][0][0] = dp[0][0][1] = (long) g[0][0];

        for (int i = 1; i < m; i++)
            dp[i][0][0] = dp[i][0][1] = dp[i - 1][0][1] * g[i][0];
        for (int j = 1; j < n; j++)
            dp[0][j][0] = dp[0][j][1] = dp[0][j - 1][1] * g[0][j];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long u1 = dp[i - 1][j][0] * g[i][j];
                long u2 = dp[i - 1][j][1] * g[i][j];
                long l1 = dp[i][j - 1][0] * g[i][j];
                long l2 = dp[i][j - 1][1] * g[i][j];
                dp[i][j][0] = Math.min(u1, Math.min(u2, Math.min(l1, l2)));
                dp[i][j][1] = Math.max(u1, Math.max(u2, Math.max(l1, l2)));
            }
        }
        int res = (int) (dp[m - 1][n - 1][1] % MOD);
        return res < 0 ? -1 : res;
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
