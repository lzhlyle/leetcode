package com.lzhlyle.leetcode.week.no283;

public class MoveZeroes_2 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) return;

        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int swap = nums[zeroIndex];
                nums[zeroIndex++] = nums[i];
                nums[i] = swap;
            }
        }
    }
}
