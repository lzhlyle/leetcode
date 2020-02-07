package com.lzhlyle.leetcode.recite.no169;

import java.util.Arrays;

public class MajorityElement_Sort {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[(nums.length - 1) >> 1];
    }
}
