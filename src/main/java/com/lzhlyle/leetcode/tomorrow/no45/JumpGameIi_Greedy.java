package com.lzhlyle.leetcode.tomorrow.no45;

public class JumpGameIi_Greedy {
    public int jump(int[] nums) {
        int end = 0, far = 0, jumps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + i > far) far = nums[i] + i;
            if (i == end) {
                end = far;
                jumps++;
            }
        }
        return jumps;
    }
}
