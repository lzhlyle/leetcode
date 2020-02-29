package com.lzhlyle.leetcode.self.no45;

public class JumpGameIi_Greedy {
    public int jump(int[] nums) {
        int currEnd = 0, currFarthest = 0, jumps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + i > currFarthest) currFarthest = nums[i] + i;
            if (i == currEnd) {
                currEnd = currFarthest;
                jumps++;
            }
        }
        return jumps;
    }
}
