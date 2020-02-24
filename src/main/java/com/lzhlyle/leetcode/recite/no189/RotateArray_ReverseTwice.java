package com.lzhlyle.leetcode.recite.no189;

public class RotateArray_ReverseTwice {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] arr, int begin, int end) {
        while (begin < end) {
            int swap = arr[begin];
            arr[begin++] = arr[end];
            arr[end--] = swap;
        }
    }
}
