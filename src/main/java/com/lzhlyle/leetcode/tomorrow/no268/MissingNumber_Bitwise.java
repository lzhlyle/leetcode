package com.lzhlyle.leetcode.tomorrow.no268;

public class MissingNumber_Bitwise {
    public int missingNumber(int[] nums) {
        int n = nums.length, xor = n;
        for (int i = 0; i < n; i++)
            xor ^= i ^ nums[i];
        return xor;
    }
}
