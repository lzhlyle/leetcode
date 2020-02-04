package com.lzhlyle.leetcode.recite.no239;

public class SlidingWindowMaximum_DP {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return new int[0];

        int[] ltr = new int[len]; // left to right
        int[] rtl = new int[len]; // right to left

        ltr[0] = nums[0];
        rtl[len - 1] = nums[len - 1];

        for (int i = 1; i < len; i++) {
            ltr[i] = (i % k == 0) ? nums[i] : Math.max(ltr[i - 1], nums[i]); // 遇上一个比谁最大

            int j = len - i - 1;
            rtl[j] = (j % k == 0) ? nums[j] : Math.max(rtl[j + 1], nums[j]); // 遇上一个比谁最大
        }

        int[] res = new int[len - k + 1];
        for (int i = 0, j = 0; i + k <= len; i++) {
            res[j++] = Math.max(rtl[i], ltr[i + k - 1]);
        }

        return res;
    }
}
