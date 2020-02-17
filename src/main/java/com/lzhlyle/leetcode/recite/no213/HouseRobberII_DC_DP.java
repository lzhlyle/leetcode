package com.lzhlyle.leetcode.recite.no213;

public class HouseRobberII_DC_DP {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        return Math.max(_rob(nums, 0, len - 1),
                _rob(nums, 1, len));
    }

    private int _rob(int[] nums, int from, int to) {
        int dp0 = 0, dp1 = nums[from];
        for (int i = from + 1; i < to; i++) {
            int oriDp0 = dp0;
            dp0 = Math.max(dp0, dp1);
            dp1 = oriDp0 + nums[i];
        }
        return Math.max(dp0, dp1);
    }
}
