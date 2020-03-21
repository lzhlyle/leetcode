package com.lzhlyle.leetcode.tomorrow.no647;

public class PalindromicSubstrings_LC_Recursion_Center {
    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length, sum = 0;
        for (int c = 0; c < len; c++) {
            sum += count(arr, c, c);
            sum += count(arr, c, c + 1);
        }
        return sum;
    }

    private int count(char[] arr, int l, int r) {
        int cnt = 0;
        while (l >= 0 && r < arr.length && arr[l--] == arr[r++]) cnt++;
        return cnt;
    }
}
