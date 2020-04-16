package com.lzhlyle.leetcode.week.no136;

public class SingleNumber_LC_Bitwise {
    public int singleNumber(int[] nums) {
        int res = nums[0], i = 1;
        while (i < nums.length) res ^= nums[i++];
        return res;
    }
}
