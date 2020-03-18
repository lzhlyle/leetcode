package com.lzhlyle.leetcode.recite.no312;

public class BurstBalloons_Recursion_LC_DP {
    public static int maxCoins4DP(int[] nums) {
        // 虚拟边界
        int len = nums.length, len2 = len + 2;
        int[] nums2 = new int[len2];
        System.arraycopy(nums, 0, nums2, 1, len);
        nums2[0] = 1;
        nums2[len + 1] = 1;

        int[][] dp = new int[len2][len2];
        // 右起，枚举左右边界
        for (int l = len2 - 2; l >= 0; l--) {
            for (int r = l + 2; r < len2; r++) {
                int max = 0;
                for (int k = l + 1; k < r; k++) { // 枚举分治点 k
                    int temp = dp[l][k] + dp[k][r] + nums2[l] * nums2[k] * nums2[r];
                    if (temp > max) max = temp;
                }
                dp[l][r] = max;
            }
        }
        return dp[0][len2 - 1];
    }
}
