package com.lzhlyle.leetcode.week.no152;

public class MaximumProductSubarray_DP_Adv {
    public int maxProduct(int[] nums) {
        int len = nums.length, max, dpMax, dpMin;
        if (len == 0) return 0;
        max = dpMax = dpMin = nums[0];
        for (int i = 1; i < len; i++) {
            int oriDpMax = dpMax;
            dpMax = Math.max(nums[i], Math.max(dpMax * nums[i], dpMin * nums[i]));
            dpMin = Math.min(nums[i], Math.min(oriDpMax * nums[i], dpMin * nums[i]));
            max = Math.max(max, dpMax);
        }
        return max;
    }
}
