package com.lzhlyle.leetcode.tomorrow.no5;

public class LongestPalindromicSubstring_BruteForce {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length, begin = 0, mlen = 1;
        if (len < 2) return s;

        for (int l = 0; l < len; l++) {
            for (int r = l; r < len; r++) {
                if (valid(arr, l, r) && r - l + 1 > mlen) {
                    mlen = r - l + 1;
                    begin = l;
                }
            }
        }

        return s.substring(begin, begin + mlen);
    }

    private boolean valid(char[] arr, int l, int r) {
        while (l < r) if (arr[l++] != arr[r--]) return false;
        return true;
    }
}
