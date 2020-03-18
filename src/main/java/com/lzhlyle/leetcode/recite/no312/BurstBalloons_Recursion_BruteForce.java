package com.lzhlyle.leetcode.recite.no312;

public class BurstBalloons_Recursion_BruteForce {
    // timeout
    public int maxCoins(int[] nums) {
        int max = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            int[] next = new int[len - 1];
            System.arraycopy(nums, 0, next, 0, i);
            System.arraycopy(nums, i + 1, next, i, len - i - 1);
            int total = nums[i];
            if (i > 0) total *= nums[i - 1];
            if (i < len - 1) total *= nums[i + 1];
            max = Math.max(max, maxCoins(next) + total);
        }
        return max;
    }
}
