package com.lzhlyle.leetcode.tomorrow.no152;

public class MaximumProductSubarray_DP {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dpMax = new int[len], dpMin = new int[len];
        dpMax[0] = dpMin[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            dpMax[i] = Math.max(nums[i], Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
            dpMin[i] = Math.min(nums[i], Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }
}
