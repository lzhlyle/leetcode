package com.lzhlyle.leetcode.recite.no647;

public class PalindromicSubstrings_LC_DP_Center {
    public int countSubstrings(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        int cnt = 0;
        for (int c = 0; c < len; c++) {
            cnt += count(arr, len, c, c);
            cnt += count(arr, len, c, c + 1);
        }
        return cnt;
    }

    private int count(char[] arr, int len, int l, int r) {
        int cnt = 0;
        while (l >= 0 && r < len && arr[l--] == arr[r++]) cnt++;
        return cnt;
    }
}
