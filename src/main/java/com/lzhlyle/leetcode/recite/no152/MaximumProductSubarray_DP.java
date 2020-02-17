package com.lzhlyle.leetcode.recite.no152;

public class MaximumProductSubarray_DP {
    public int maxProduct(int[] nums) {
        int len = nums.length, max;
        if (len == 0) return 0;
        int[] dpMax = new int[len], dpMin = new int[len];
        dpMax[0] = dpMin[0] = max = nums[0];
        for (int i = 1; i < len; i++) {
            dpMax[i] = Math.max(dpMin[i - 1] * nums[i], Math.max(dpMax[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMin[i - 1] * nums[i], Math.min(dpMax[i - 1] * nums[i], nums[i]));
            if (dpMax[i] > max) max = dpMax[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, -5, -2, -4, 3};
        int res = new MaximumProductSubarray_DP().maxProduct(nums);
        System.out.println(res);
    }
}
