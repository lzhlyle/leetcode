package com.lzhlyle.leetcode.week.no5;

public class LongestPalindromicSubstring_LC {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length, begin = 0, mlen = 1;
        if (len < 2) return s;

        for (int i = 0; i < len; i++) {
            int l = i - 1, r = i;
            // skip the same
            while (r + 1 < len && arr[r] == arr[r + 1]) r++;
            i = r++;
            // expand
            while (l >= 0 && r < len && arr[l] == arr[r]) {
                l--;
                r++;
            }
            int dis = (r - 1) - (l + 1) + 1;
            if (dis > mlen) {
                mlen = dis;
                begin = l + 1;
            }
        }

        return s.substring(begin, begin + mlen);
    }
}
