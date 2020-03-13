package com.lzhlyle.leetcode.self.no552;

public class StudentAttendanceRecordIi_DP {
    public int checkRecord(int n) {
        int _MOD = 1000000007;
        long dp00, dp01, dp02, dp10, dp11, dp12;
        dp00 = dp01 = dp10 = 1;
        dp11 = dp02 = dp12 = 0;
        for (int i = 2; i <= n; i++) {
            long t00 = dp00, t01 = dp01, t02 = dp02, t10 = dp10, t11 = dp11, t12 = dp12;
            // +P
            dp00 = (t00 + t01 + t02) % _MOD;
            dp10 = (t10 + t11 + t12) % _MOD;

            // +L
            dp01 = t00;
            dp02 = t01;
            dp11 = t10;
            dp12 = t11;

            // +A
            dp10 += (t00 + t01 + t02) % _MOD;
        }
        return (int) ((dp00 + dp01 + dp02 + dp10 + dp11 + dp12) % _MOD);
    }
}
