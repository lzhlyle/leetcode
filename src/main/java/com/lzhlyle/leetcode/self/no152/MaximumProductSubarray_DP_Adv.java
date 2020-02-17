package com.lzhlyle.leetcode.self.no152;

public class MaximumProductSubarray_DP_Adv {
    public int maxProduct(int[] nums) {
        int len = nums.length, max, dpMax, dpMin;
        dpMax = dpMin = max = nums[0];
        for (int i = 1; i < len; i++) {
            int num = nums[i], oriDpMax = dpMax;
            dpMax = Math.max(num, Math.max(dpMax * num, dpMin * num));
            dpMin = Math.min(num, Math.min(oriDpMax * num, dpMin * num));
            max = Math.max(max, Math.max(dpMax, dpMin));
        }
        return max;
    }
}
