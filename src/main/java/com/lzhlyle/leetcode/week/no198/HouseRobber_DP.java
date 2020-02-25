package com.lzhlyle.leetcode.week.no198;

public class HouseRobber_DP {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[][] dp = new int[len][2]; // 0:non-rob, 1:rob
        dp[0][1] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
