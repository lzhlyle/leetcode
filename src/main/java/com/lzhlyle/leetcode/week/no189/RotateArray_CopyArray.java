package com.lzhlyle.leetcode.week.no189;

public class RotateArray_CopyArray {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        int[] temp = new int[k];
        System.arraycopy(nums, len - k, temp, 0, k);
        System.arraycopy(nums, 0, nums, k, len - k);
        System.arraycopy(temp, 0, nums, 0, k);
    }
}
