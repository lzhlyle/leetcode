package com.lzhlyle.leetcode.tomorrow.no53;

public class MaximumSubarray_DP {
    public int maxSubArray(int[] nums) {
        int len = nums.length, max;
        if (len == 0) return 0;

        int[] dp = new int[len];
        dp[0] = max = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
