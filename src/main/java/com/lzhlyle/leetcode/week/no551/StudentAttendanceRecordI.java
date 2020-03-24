package com.lzhlyle.leetcode.week.no551;

public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        if (s.contains("LLL")) return false;
        int a = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A' && ++a == 2) return false;
        }
        return true;
    }
}
