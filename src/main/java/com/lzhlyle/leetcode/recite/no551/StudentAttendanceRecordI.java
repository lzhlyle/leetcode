package com.lzhlyle.leetcode.recite.no551;

public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        if (s.contains("LLL")) return false;
        int aCnt = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') aCnt++;
            if (aCnt == 2) return false;
        }
        return true;
    }
}
