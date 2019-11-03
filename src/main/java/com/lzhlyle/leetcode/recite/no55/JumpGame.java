package com.lzhlyle.leetcode.recite.no55;

public class JumpGame {
    // 1ms
    public boolean canJump(int[] nums) {
        // base condition
        if (nums == null || nums.length < 1) return false;
        if (nums.length == 1) return true;

        // backward
        int whereZero = -1;
        int expectDistance = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (expectDistance == 0 && nums[i] <= 0) {
                whereZero = i;
                expectDistance = (whereZero == nums.length - 1 ? 1 : 2);
            } else if (expectDistance >= (whereZero == nums.length - 1 ? 1 : 2)) {
                if (nums[i] < expectDistance) expectDistance++;
                else expectDistance = 0;
            }
        }

        return expectDistance == 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 0};
        boolean can = new JumpGame().canJump(nums);
        System.out.println(can);
    }
}
