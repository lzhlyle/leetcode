package com.lzhlyle.leetcode.self.no152;

public class MaximumProductSubarray_DP {
    public int maxProduct(int[] nums) {
        int len = nums.length, max;
        int[] dpMax = new int[len], dpMin = new int[len];
        dpMax[0] = dpMin[0] = max = nums[0];
        for (int i = 1; i < len; i++) {
            int num = nums[i];
            dpMax[i] = Math.max(num, Math.max(dpMax[i - 1] * num, dpMin[i - 1] * num));
            dpMin[i] = Math.min(num, Math.min(dpMax[i - 1] * num, dpMin[i - 1] * num));
            max = Math.max(max, Math.max(dpMax[i], dpMin[i]));
        }
        return max;
    }
}
