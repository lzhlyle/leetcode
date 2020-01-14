package com.lzhlyle.leetcode.tomorrow.no55;

public class JumpGame_Greedy_Backward {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 1) return false;
        if (nums.length == 1) return true;
        int last = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= last) last = i;
        }
        return last == 0;
    }

}
