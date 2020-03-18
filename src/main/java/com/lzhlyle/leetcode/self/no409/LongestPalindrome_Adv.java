package com.lzhlyle.leetcode.self.no409;

public class LongestPalindrome_Adv {
    public int longestPalindrome(String s) {
        long freq = 0b0L; // 64 bits > 58 chars
        int odd = 0;
        for (char c : s.toCharArray()) {
            long ori = freq;
            if ((freq ^= 1L << (c - 'A')) > ori) odd++;
            else odd--;
        }
        return s.length() - odd + (odd > 0 ? 1 : 0);
    }
}
