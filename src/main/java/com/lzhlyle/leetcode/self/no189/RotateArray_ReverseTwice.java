package com.lzhlyle.leetcode.self.no189;

public class RotateArray_ReverseTwice {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            int swap = nums[end];
            nums[end--] = nums[begin];
            nums[begin++] = swap;
        }
    }
}
