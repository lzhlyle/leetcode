package com.lzhlyle.leetcode.recite.no551;

public class StudentAttendanceRecordI_Adv {
    public boolean checkRecord(String s) {
        int a = 0, l = 1, lastL = -2;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') a++;
            else if (c == 'L') {
                if (lastL == i - 1) l++;
                else l = 1;
                lastL = i;
            }
            if (a == 2 || l == 3) return false;
        }
        return true;
    }
}
