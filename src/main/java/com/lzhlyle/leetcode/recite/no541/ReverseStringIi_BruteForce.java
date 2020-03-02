package com.lzhlyle.leetcode.recite.no541;

public class ReverseStringIi_BruteForce {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i += 2 * k) {
            int left = i, right = Math.min(i + k - 1, arr.length - 1);
            swap(arr, left, right);
        }
        return String.valueOf(arr);
    }

    private void swap(char[] arr, int left, int right) {
        while (left < right) {
            arr[left] ^= arr[right];
            arr[right] ^= arr[left];
            arr[left++] ^= arr[right--];
        }
    }
}
