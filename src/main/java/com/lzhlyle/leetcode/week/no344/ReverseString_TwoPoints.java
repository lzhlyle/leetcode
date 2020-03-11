package com.lzhlyle.leetcode.week.no344;

public class ReverseString_TwoPoints {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            s[l] ^= s[r];
            s[r] ^= s[l];
            s[l++] ^= s[r--];
        }
    }
}
