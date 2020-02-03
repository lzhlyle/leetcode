package com.lzhlyle.leetcode.self.no300;

import java.util.Arrays;

public class LongestIncreasingSubsequence_DP {
    public int lengthOfLIS(int[] nums) {
        if (nums == null) return 0;
        int len;
        if ((len = nums.length) < 2) return len;

        int[] dp = new int[len];
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
