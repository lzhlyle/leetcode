package com.lzhlyle.leetcode.tomorrow.no541;

public class ReverseStringIi_BruteForce {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int left = 0, step = 2 * k; left < arr.length; left += step) {
            int right = Math.min(left + k - 1, arr.length - 1);
            reverse(arr, left, right);
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
