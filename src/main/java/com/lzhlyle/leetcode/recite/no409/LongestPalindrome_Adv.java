package com.lzhlyle.leetcode.recite.no409;

public class LongestPalindrome_Adv {
    public int longestPalindrome(String s) {
        int odd = 0;
        long freq = 0b0L; // 64 bits > 58 chars(from A to z)
        for (char c : s.toCharArray()) {
            long ori = freq;
            freq ^= 1L << (c - 'A');
            if (freq > ori) odd++;
            else odd--;
        }
        return s.length() - odd + (odd > 0 ? 1 : 0);
    }

    public static void main(String[] args) {
        int res = new LongestPalindrome_Adv().longestPalindrome("aaaAaaaa");
        System.out.println(res);
    }
}
