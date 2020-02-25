package com.lzhlyle.leetcode.week.no198;

public class HouseRobber_DP_Adv {
    public int rob(int[] nums) {
        int len = nums.length, dp0 = 0, dp1; // 0:non-rob, 1:rob
        if (len == 0) return 0;
        dp1 = nums[0];
        for (int i = 1; i < len; i++) {
            int oriDp0 = dp0;
            if (dp1 > dp0) dp0 = dp1;
            dp1 = oriDp0 + nums[i];
        }
        return Math.max(dp0, dp1);
    }
}
