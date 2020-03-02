package com.lzhlyle.leetcode.recite.no344;

public class ReverseString_Recursion {
    public void reverseString(char[] s) {
        swap(s, 0, s.length - 1);
    }

    private void swap(char[] arr, int left, int right) {
        if (arr.length < 2) return;
        if (left < right) {
            arr[left] ^= arr[right];
            arr[right] ^= arr[left];
            arr[left] ^= arr[right];

            swap(arr, left + 1, right - 1);
        }
    }
}
