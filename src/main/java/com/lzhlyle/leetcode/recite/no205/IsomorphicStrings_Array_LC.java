package com.lzhlyle.leetcode.recite.no205;

public class IsomorphicStrings_Array_LC {
    public boolean isIsomorphic(String s, String t) {
        if (s.isEmpty()) return true;
        int[] from = new int[256], to = new int[256];
        for (int i = 0; i < s.length(); i++) {
            int schar = s.charAt(i), tchar = t.charAt(i);
            if (from[schar] != to[tchar]) return false;
            from[schar] = to[tchar] = i + 1; // exclude 0
        }
        return true;
    }
}
