package com.lzhlyle.leetcode.recite.no53;

public class MaximumSubarray_DP_Adv {
    public int maxSubArray(int[] nums) {
        int len = nums.length, max;
        if (len == 0) return 0;

        int dp = max = nums[0];
        for (int i = 1; i < len; i++) {
            dp = Math.max(dp, 0) + nums[i];
            max = Math.max(max, dp);
        }
        return max;
    }
}
