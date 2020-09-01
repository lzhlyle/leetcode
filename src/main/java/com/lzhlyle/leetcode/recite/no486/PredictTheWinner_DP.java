package com.lzhlyle.leetcode.recite.no486;

public class PredictTheWinner_DP {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        if (n <= 2) return true;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            dp[i][i] = nums[i];
        for (int l = n - 2; l >= 0; l--)
            for (int r = l + 1; r < n; r++)
                dp[l][r] = Math.max(nums[l] - dp[l + 1][r], nums[r] - dp[l][r - 1]);
        return dp[0][n - 1] >= 0;
    }
}
