package com.lzhlyle.leetcode.week.no300;

import java.util.Arrays;

public class LongestIncreasingSubsequence_DP {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;

        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
