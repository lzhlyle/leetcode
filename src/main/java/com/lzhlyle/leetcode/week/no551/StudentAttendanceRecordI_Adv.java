package com.lzhlyle.leetcode.week.no551;

public class StudentAttendanceRecordI_Adv {
    public boolean checkRecord(String s) {
        int a = 0, l = 1, li = -2;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A' && ++a == 2) return false;
            else if (c == 'L') {
                if (li == i - 1) l++;
                else l = 1;
                li = i;
                if (l == 3) return false;
            }
        }
        return true;
    }
}
