package com.lzhlyle.leetcode.self.no53;

public class MaximumSubarray_DP_Adv {
    public int maxSubArray(int[] nums) {
        int len = nums.length, max;
        if (len == 0) return 0;
        int dp = max = nums[0];
        for (int i = 1; i < len; i++) {
            if (dp > 0) dp += nums[i];
            else dp = nums[i];
            if (dp > max) max = dp;
        }
        return max;
    }
}
