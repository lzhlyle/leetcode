package com.lzhlyle.leetcode.week.no189;

public class RotateArray_BruteForce {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        while (k-- > 0) {
            int forward = nums[len - 1];
            System.arraycopy(nums, 0, nums, 1, len - 1);
            nums[0] = forward;
        }
    }
}
