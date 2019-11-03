package com.lzhlyle.leetcode.self.no55;

public class JumpGame_3 {
    // 2ms
    public boolean canJump(int[] nums) {
        // base condition
        if (nums == null || nums.length < 1) return false;
        if (nums.length == 1) return true;

        // greedy, forward
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false;
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 0, 4};
        boolean can = new JumpGame_3().canJump(nums);
        System.out.println(can);
    }
}
