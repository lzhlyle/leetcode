package com.lzhlyle.leetcode.recite.no5;

public class LongestPalindromicSubstring_LC {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length, begin = 0, maxLen = 1;
        if (len < 2) return s;
        for (int l = 0; l < len; l++) {
            // skip
            int r = l--;
            while (r + 1 < len && arr[r] == arr[r + 1]) r++;
            int nextL = r++;
            // expand
            while (l >= 0 && r < len && arr[l] == arr[r]) {
                l--;
                r++;
            }
            // push
            if (r - l - 1 > maxLen) {
                maxLen = r - l - 1;
                begin = l + 1;
            }
            // reverse
            l = nextL;
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        String str = "cccccbababccccc";
        String res = new LongestPalindromicSubstring_LC().longestPalindrome(str);
        System.out.println(res);
    }
}
