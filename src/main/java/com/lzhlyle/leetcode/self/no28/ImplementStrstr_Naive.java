package com.lzhlyle.leetcode.self.no28;

public class ImplementStrstr_Naive {
    // naive
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        for (int l = 0, len; l < m - n + 1; l++) {
            for (len = 0; len < n; len++) {
                if (haystack.charAt(l + len) != needle.charAt(len)) break;
            }
            if (len == n) return l;
        }
        return -1;
    }
}
