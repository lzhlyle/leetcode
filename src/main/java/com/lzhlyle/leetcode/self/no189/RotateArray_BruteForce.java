package com.lzhlyle.leetcode.self.no189;

public class RotateArray_BruteForce {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        for (int i = 0; i < k; i++) {
            int prev = nums[len - 1];
            for (int j = len - 1; j > 0; j--) nums[j] = nums[j - 1];
            nums[0] = prev;
        }
    }
}
