package com.lzhlyle.leetcode.tomorrow.no189;

public class RotateArray_BruteForce {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        for (int i = 0; i < k; i++) {
            int forward = nums[len - 1];
            System.arraycopy(nums, 0, nums, 1, len - 1);
            nums[0] = forward;
        }
    }
}
