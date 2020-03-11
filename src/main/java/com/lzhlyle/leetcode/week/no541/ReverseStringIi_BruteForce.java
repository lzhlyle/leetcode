package com.lzhlyle.leetcode.week.no541;

public class ReverseStringIi_BruteForce {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int l = 0, step = 2 * k; l < arr.length; l += step) {
            int r = Math.min(arr.length - 1, l + k - 1);
            reverse(arr, l, r);
        }
        return new String(arr);
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            arr[l] ^= arr[r];
            arr[r] ^= arr[l];
            arr[l++] ^= arr[r--];
        }
    }
}
