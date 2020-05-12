package com.lzhlyle.leetcode.recite.no540;

public class SingleElementInASortedArray_BS_LC {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if ((mid & 1) == 1) mid -= 1;
            if (nums[mid] == nums[mid + 1]) l = mid + 2;
            else r = mid;
        }
        return nums[l];
    }
}
