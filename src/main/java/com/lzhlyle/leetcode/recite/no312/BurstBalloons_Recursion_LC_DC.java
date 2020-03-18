package com.lzhlyle.leetcode.recite.no312;

public class BurstBalloons_Recursion_LC_DC {

    public int maxCoins(int[] nums) {
        // 虚拟边界
        int len = nums.length, len2 = len + 2;
        int[] nums2 = new int[len2];
        System.arraycopy(nums, 0, nums2, 1, len);
        nums2[0] = 1;
        nums2[len + 1] = 1;

        return dc(nums2, 0, len2 - 1, new int[len2][len2]);
    }

    private int dc(int[] nums, int begin, int end, int[][] memo) {
        if (begin + 1 == end) return 0; // 只剩两个球
        if (memo[begin][end] != 0) return memo[begin][end];

        int max = 0;
        // f(i, j) = max(f(i,k) + f(k,j) + nums[i] * nums[k] * nums[j])
        for (int i = begin + 1; i < end; i++) {
            int temp = dc(nums, begin, i, memo) + dc(nums, i, end, memo) + nums[begin] * nums[i] * nums[end];
            if (temp > max) max = temp;
        }
        return memo[begin][end] = max;
    }
}
