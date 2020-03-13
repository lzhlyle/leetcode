package com.lzhlyle.leetcode.recite.no552;

public class StudentAttendanceRecordIi_DP_Adv_Adv {
    public int checkRecord(int n) {
        int _MOD = 1000000007;
        long dp00, dp01, dp02, dp10, dp11, dp12;
        dp00 = dp01 = dp10 = 1;
        dp11 = dp02 = dp12 = 0;

        for (int i = 2; i <= n; i++) {
            long t00 = dp00, t10 = dp10;
            dp00 = (t00 + dp01 + dp02) % _MOD;
            dp10 = (t10 + dp11 + dp12 + t00 + dp01 + dp02) % _MOD;
            dp02 = dp01;
            dp01 = t00;
            dp12 = dp11;
            dp11 = t10;
        }

        return (int) ((dp00 + dp01 + dp02 + dp10 + dp11 + dp12) % _MOD);
    }

    public static void main(String[] args) {
        int res = new StudentAttendanceRecordIi_DP_Adv_Adv().checkRecord(2);
        System.out.println(res);
    }
}
