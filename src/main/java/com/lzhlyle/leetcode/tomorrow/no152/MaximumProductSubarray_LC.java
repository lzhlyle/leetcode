package com.lzhlyle.leetcode.tomorrow.no152;

public class MaximumProductSubarray_LC {
    public int maxProduct(int[] nums) {
        int len = nums.length, left = 0, right = 0, max = nums[0];
        for (int i = 0; i < len; i++) {
            left = (left == 0 ? 1 : left) * nums[i];
            right = (right == 0 ? 1 : right) * nums[len - i - 1];
            max = Math.max(max, Math.max(left, right));
        }
        return max;
    }
}
