package com.lzhlyle.leetcode.recite.no152;

public class MaximumProductSubarray_DP_Adv {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int dpMax, dpMin, max;
        dpMax = dpMin = max = nums[0];
        for (int i = 1; i < len; i++) {
            int oriDpMax = dpMax;
            dpMax = Math.max(dpMin * nums[i], Math.max(dpMax * nums[i], nums[i]));
            dpMin = Math.min(dpMin * nums[i], Math.min(oriDpMax * nums[i], nums[i]));
            if (dpMax > max) max = dpMax;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, -5, -2, -4, 3};
        int res = new MaximumProductSubarray_DP_Adv().maxProduct(nums);
        System.out.println(res);
    }
}
