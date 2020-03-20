package com.lzhlyle.leetcode.self.no647;

public class PalindromicSubstrings_LC_DP_Center {
    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length, sum = 0;
        for (int c = 0; c < len; c++) {
            sum += _count(arr, len, c, c);
            sum += _count(arr, len, c, c + 1);
        }
        return sum;
    }

    private int _count(char[] arr, int len, int l, int r) {
        int cnt = 0;
        while (l >= 0 && r < len && arr[l--] == arr[r++]) cnt++;
        return cnt;
    }
}
