package com.lzhlyle.leetcode.week.no55;

public class JumpGame_Greedy_Backward {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 1) return false;
        if (nums.length == 1) return true;
        int last = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            last = (i + nums[i] >= last) ? i : last;
        }
        return last == 0;
    }
}
