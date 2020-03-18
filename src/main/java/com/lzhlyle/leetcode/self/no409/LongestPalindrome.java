package com.lzhlyle.leetcode.self.no409;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] freq = new int[58];
        for (char c : s.toCharArray()) freq[c - 'A']++;
        int odd = 0;
        for (int f : freq) if (f % 2 == 1) odd++;
        return s.length() - odd + (odd > 0 ? 1 : 0);
    }
}
