package com.lzhlyle.leetcode.week.lcci0803;

public class MagicIndexLcci_BS_LC {
    public int findMagicIndex(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) return i;
            if (nums[i] > i) i = nums[i];
            else i++;
        }
        return -1;
    }
}
