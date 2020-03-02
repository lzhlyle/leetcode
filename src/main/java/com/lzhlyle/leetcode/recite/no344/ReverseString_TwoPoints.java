package com.lzhlyle.leetcode.recite.no344;

public class ReverseString_TwoPoints {
    public void reverseString(char[] s) {
        if (s.length < 2) return;
        int left = 0, right = s.length - 1;
        while (left < right) {
            char swap = s[right];
            s[right--] = s[left];
            s[left++] = swap;
        }
    }
}
