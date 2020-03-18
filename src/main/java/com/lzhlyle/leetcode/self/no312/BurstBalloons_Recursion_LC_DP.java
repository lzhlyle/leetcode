package com.lzhlyle.leetcode.self.no312;

public class BurstBalloons_Recursion_LC_DP {
    public static int maxCoins4DP(int[] nums) {
        int len = nums.length + 2;
        int[] arr = new int[len];
        System.arraycopy(nums, 0, arr, 1, nums.length);
        arr[0] = arr[len - 1] = 1;

        int[][] dp = new int[len][len];
        for (int r = 2; r < len; r++) {
            for (int l = r - 1; l > -1; l--) {
                for (int i = l + 1; i < r; i++) {
                    int curr = dp[l][i] + dp[i][r] + arr[l] * arr[i] * arr[r];
                    if (curr > dp[l][r]) dp[l][r] = curr;
                }
            }
        }
        return dp[0][len - 1];
    }
}
