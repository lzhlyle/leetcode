package com.lzhlyle.leetcode.recite.no55;

public class JumpGame_3 {
    // 2ms
    public boolean canJump(int[] nums) {
        // base condition
        if (nums == null || nums.length < 1) return false;
        if (nums.length == 1) return true;

        // greedy, forward
        int maxPosition = 0;
        for (int position = 0; position < nums.length; position++) {
            if (position > maxPosition) return false;
            maxPosition = Math.max(maxPosition, nums[position] + position);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 0};
        boolean can = new JumpGame_3().canJump(nums);
        System.out.println(can);
    }
}
