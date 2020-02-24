package com.lzhlyle.leetcode.recite.no5;

public class LongestPalindromicSubstring_BruteForce_Adv {
    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        int begin = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(expand(s, i, i), expand(s, i, i + 1));
            if (len > end - begin) {
                begin = i - ((len - 1) >> 1);
                end = i + (len >> 1);
            }
        }
        return s.substring(begin, end + 1);
    }

    private int expand(String str, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
