package com.lzhlyle.leetcode.tomorrow.no209;

public class MinimumSizeSubarraySum_SlideWindow {
    // slide-window: O(n)
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int r = 0, l = 0, sum = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= s) {
                min = Math.min(min, r - l + 1);
                sum -= nums[l++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
