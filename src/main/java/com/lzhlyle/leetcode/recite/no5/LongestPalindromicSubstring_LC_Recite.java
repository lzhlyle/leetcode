package com.lzhlyle.leetcode.recite.no5;

public class LongestPalindromicSubstring_LC_Recite {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length, begin = 0, maxLen = 1;
        if (len < 2) return s;
        for (int l = 0; l < len; l++) {
            int r = l--;
            while (r + 1 < len && arr[r] == arr[r + 1]) r++;
            int nextL = r++;
            while (l >= 0 && r < len && arr[l] == arr[r]) {
                l--;
                r++;
            }
            if (r - l - 1 > maxLen) {
                maxLen = r - l - 1;
                begin = l + 1;
            }
            l = nextL;
        }
        return s.substring(begin, begin + maxLen);
    }
}
