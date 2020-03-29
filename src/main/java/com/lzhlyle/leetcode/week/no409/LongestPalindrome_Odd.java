package com.lzhlyle.leetcode.week.no409;

public class LongestPalindrome_Odd {
    public int longestPalindrome(String s) {
        int[] freq = new int[58];
        for (char c : s.toCharArray()) ++freq[c - 'A'];
        int odd = 0;
        for (int f : freq) odd += f & 1;
        return s.length() - odd + (odd > 0 ? 1 : 0);
    }
}
