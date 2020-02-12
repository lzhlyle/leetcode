package com.lzhlyle.leetcode.week.no239;

public class SlidingWindowMaximum_BruteForce {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return new int[0];
        int[] res = new int[len - k + 1];
        for (int i = 0; i < len - k + 1; i++) {
            int max = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }
}
