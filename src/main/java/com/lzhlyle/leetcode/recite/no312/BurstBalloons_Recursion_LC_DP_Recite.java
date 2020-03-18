package com.lzhlyle.leetcode.recite.no312;

public class BurstBalloons_Recursion_LC_DP_Recite {
    public static int maxCoins4DP(int[] nums) {
        int len = nums.length + 2;
        int[] arr = new int[len + 2];
        System.arraycopy(nums, 0, arr, 1, nums.length);
        arr[0] = arr[len - 1] = 1;

        int[][] dp = new int[len][len];
        for (int r = 2; r < len; r++) { // 枚举右边界
            for (int l = r - 2; l >= 0; l--) { // 枚举左边界，从贴近右边界向左
                for (int i = l + 1; i < r; i++) {
                    int curr = dp[l][i] + dp[i][r] + arr[l] * arr[i] * arr[r];
                    if (curr > dp[l][r]) dp[l][r] = curr;
                }
            }
        }
        return dp[0][len - 1];
    }
}
