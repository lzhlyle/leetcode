package com.lzhlyle.leetcode.recite.no136;

public class SingleNumber_LC_Bitwise {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                res = res ^ nums[i];
            }
        }
        return res;
    }
}
