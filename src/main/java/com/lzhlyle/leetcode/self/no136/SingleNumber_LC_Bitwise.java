package com.lzhlyle.leetcode.self.no136;

public class SingleNumber_LC_Bitwise {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
