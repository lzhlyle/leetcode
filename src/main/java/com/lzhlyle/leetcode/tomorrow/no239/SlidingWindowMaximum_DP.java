package com.lzhlyle.leetcode.tomorrow.no239;

public class SlidingWindowMaximum_DP {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return new int[0];

        int[] ltr = new int[len], rtl = new int[len];
        ltr[0] = nums[0];
        rtl[len - 1] = nums[len - 1];
        for (int i = 1; i < len; i++) {
            ltr[i] = (i % k == 0) ? nums[i] : Math.max(nums[i], ltr[i - 1]);
            int j = len - i - 1;
            rtl[j] = (j % k == 0) ? nums[j] : Math.max(nums[j], rtl[j + 1]);
        }

        int[] res = new int[len - k + 1];
        for (int i = 0, ri = 0; i < len - k + 1; i++) {
            res[ri++] = Math.max(rtl[i], ltr[i + k - 1]);
        }
        return res;
    }
}
