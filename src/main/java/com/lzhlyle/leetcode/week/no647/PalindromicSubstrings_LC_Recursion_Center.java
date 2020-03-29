package com.lzhlyle.leetcode.week.no647;

public class PalindromicSubstrings_LC_Recursion_Center {
    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        int sum = 0;
        for (int c = 0; c < arr.length; c++) {
            sum += expend(arr, c, c) + expend(arr, c, c + 1);
        }
        return sum;
    }

    private int expend(char[] arr, int l, int r) {
        int cnt = 0;
        while (l >= 0 && r < arr.length && arr[l] == arr[r]) {
            l--;
            r++;
            cnt++;
        }
        return cnt;
    }
}
