package com.lzhlyle.leetcode.tomorrow.no55;

public class JumpGame_Greedy_Forward {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 1) return false;
        if (nums.length == 1) return true;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false;
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
