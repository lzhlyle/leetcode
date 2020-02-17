package com.lzhlyle.leetcode.recite.no152;

public class MaximumProductSubarray_LC {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int max = nums[0], left = 0, right = 0;
        for (int i = 0; i < len; i++) {
            left = (left == 0 ? 1 : left) * nums[i]; // 正遍历
            right = (right == 0 ? 1 : right) * nums[len - i - 1]; // 倒遍历
            max = Math.max(max, Math.max(left, right));
        }
        return max;
    }
}
