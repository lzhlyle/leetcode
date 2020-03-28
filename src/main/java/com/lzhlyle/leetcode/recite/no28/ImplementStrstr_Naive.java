package com.lzhlyle.leetcode.recite.no28;

public class ImplementStrstr_Naive {
    // naive
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        for (int l = 0, r; l <= m - n; l++) {
            for (r = 0; r < n; r++) {
                if (haystack.charAt(l + r) != needle.charAt(r)) break;
            }
            if (r == n) return l;
        }
        return -1;
    }
}
