package com.lzhlyle.leetcode.tomorrow.no198;

public class HouseRobber_DP_Adv {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int dp0 = 0, dp1 = nums[0]; // 0:not-rob, 1:rob
        for (int i = 1; i < len; i++) {
            int oriDp0 = dp0;
            dp0 = Math.max(dp0, dp1);
            dp1 = oriDp0 + nums[i];
        }
        return Math.max(dp0, dp1);
    }
}
