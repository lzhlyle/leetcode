package com.lzhlyle.leetcode.recite.no238;

import java.util.Arrays;

public class ProductOfArrayExceptSelf_LC_OneLoop {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, l = 1, r = 1;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for (int i = 0, j = n - 1; i < n - 1; i++, j--) {
            l *= nums[i];
            r *= nums[j];
            res[i + 1] *= l;
            res[j - 1] *= r;
        }
        return res;
    }
}
