package com.lzhlyle.leetcode.recite.no238;

public class ProductOfArrayExceptSelf_LC {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0, l = 1; i < nums.length; i++) {
            res[i] = l;
            l *= nums[i];
        }
        for (int i = nums.length - 1, r = 1; i >= 0; i--) {
            res[i] *= r;
            r *= nums[i];
        }
        return res;
    }
}
