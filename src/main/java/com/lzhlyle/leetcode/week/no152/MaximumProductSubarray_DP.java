package com.lzhlyle.leetcode.week.no152;

public class MaximumProductSubarray_DP {
    public int maxProduct(int[] nums) {
        int len = nums.length, max;
        if (len == 0) return 0;
        int[] dpMax = new int[len], dpMin = new int[len];
        max = dpMax[0] = dpMin[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dpMax[i] = Math.max(nums[i], Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
            dpMin[i] = Math.min(nums[i], Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }
}
