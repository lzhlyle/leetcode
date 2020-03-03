package com.lzhlyle.leetcode.week.no5;

public class LongestPalindromicSubstring_BruteForce_Adv {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length, begin = 0, mlen = 1;
        if (len < 2) return s;

        for (int c = 0; c < len; c++) {
            int vlen = Math.max(valid(arr, c, c), valid(arr, c, c + 1));
            if (vlen > mlen) {
                mlen = vlen;
                begin = c - ((vlen - 1) >> 1);
            }
        }

        return s.substring(begin, begin + mlen);
    }

    private int valid(char[] arr, int l, int r) {
        while (l >= 0 && r < arr.length && arr[l] == arr[r]) {
            l--;
            r++;
        }
        return (r - 1) - (l + 1) + 1;
    }
}
