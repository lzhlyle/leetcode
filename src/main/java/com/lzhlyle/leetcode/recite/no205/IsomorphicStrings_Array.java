package com.lzhlyle.leetcode.recite.no205;

import java.util.Arrays;

public class IsomorphicStrings_Array {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.isEmpty()) return true;
        int[] from = new int[256], to = new int[256];
        Arrays.fill(from, -1);
        Arrays.fill(to, -1);
        for (int i = 0; i < s.length(); i++) {
            int schar = s.charAt(i), tchar = t.charAt(i);
            if (from[schar] > -1 && from[schar] != tchar) return false;
            if (from[schar] == -1 && to[tchar] > -1) return false;
            if (from[schar] == -1 && to[tchar] == -1) {
                from[schar] = tchar;
                to[tchar] = schar;
            }
        }
        return true;
    }
}
