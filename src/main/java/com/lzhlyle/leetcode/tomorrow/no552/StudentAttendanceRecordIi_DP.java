package com.lzhlyle.leetcode.tomorrow.no552;

public class StudentAttendanceRecordIi_DP {
    public int checkRecord(int n) {
        int MOD = 1000000007;
        long dp00, dp01, dp02, dp10, dp11, dp12; // A?L?
        dp10 = dp01 = dp00 = 1; // A/L/P
        dp02 = dp11 = dp12 = 0;
        for (int i = 2; i <= n; i++) {
            long t00 = dp00, t01 = dp01, t02 = dp02, t10 = dp10, t11 = dp11, t12 = dp12;
            dp00 = (t00 + t01 + t02) % MOD;
            dp10 = (t10 + t11 + t12 + t00 + t01 + t02) % MOD;
            dp01 = t00;
            dp11 = t10;
            dp02 = t01;
            dp12 = t11;
        }
        return (int) ((dp00 + dp01 + dp02 + dp10 + dp11 + dp12) % MOD);
    }
}
