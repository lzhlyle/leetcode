package com.lzhlyle.leetcode.recite.no45;

public class JumpGameIi_Greedy {
    public int jump(int[] nums) {
        int currEnd = 0, currFarthest = 0, step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currFarthest = Math.max(currFarthest, nums[i] + i);
            if (i == currEnd) {
                currEnd = currFarthest;
                step++;
            }
        }
        return step;
    }
}
