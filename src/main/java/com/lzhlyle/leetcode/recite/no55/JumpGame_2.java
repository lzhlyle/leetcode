package com.lzhlyle.leetcode.recite.no55;

public class JumpGame_2 {
    // 1ms
    public boolean canJump(int[] nums) {
        // base condition
        if (nums == null || nums.length < 1) return false;
        if (nums.length == 1) return true;

        // greedy, backward
        int backPosition = nums.length - 1;
        for (int position = backPosition; position >= 0; position--) {
            if (nums[position] + position >= backPosition) backPosition = position;
        }
        return backPosition == 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 0};
        boolean can = new JumpGame_2().canJump(nums);
        System.out.println(can);
    }
}
