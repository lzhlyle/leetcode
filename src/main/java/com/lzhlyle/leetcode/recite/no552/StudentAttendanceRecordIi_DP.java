package com.lzhlyle.leetcode.recite.no552;

public class StudentAttendanceRecordIi_DP {
    public int checkRecord(int n) {
        int _MOD = 1000000007;
        long[][][] dp = new long[n + 1][2][3]; // i, A:{0:non, 1:contains}, L:{0,1,2}
        dp[1][1][0] = 1; // A
        dp[1][0][1] = 1; // L
        dp[1][0][0] = 1; // P
        for (int i = 2; i <= n; i++) {
            // +P
            // 0A0L = 0A0L + 0A1L + 0A2L
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % _MOD;
            // 1A0L = 1A0L + 1A1L + 1A2L
            dp[i][1][0] = (dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % _MOD;

            // +L
            // 0A1L = 0A0L
            dp[i][0][1] = dp[i - 1][0][0] % _MOD;
            // 0A2L = 0A1L
            dp[i][0][2] = dp[i - 1][0][1] % _MOD;
            // 1A1L = 1A0L
            dp[i][1][1] = dp[i - 1][1][0] % _MOD;
            // 1A2L = 1A1L
            dp[i][1][2] = dp[i - 1][1][1] % _MOD;

            // +A
            // 1A0L = 0A0L + 0A1L + 0A2L
            dp[i][1][0] += (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % _MOD;
        }

        return (int) ((dp[n][0][0] + dp[n][0][1] + dp[n][0][2] + dp[n][1][0] + dp[n][1][1] + dp[n][1][2]) % _MOD);
    }

    public static void main(String[] args) {
        int res = new StudentAttendanceRecordIi_DP().checkRecord(2);
        System.out.println(res);
    }
}
