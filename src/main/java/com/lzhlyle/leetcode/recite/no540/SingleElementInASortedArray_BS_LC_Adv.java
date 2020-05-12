package com.lzhlyle.leetcode.recite.no540;

public class SingleElementInASortedArray_BS_LC_Adv {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == nums[mid ^ 1]) l = mid + 1; // NOT mid + 2
            else r = mid;
        }
        return nums[l];
    }
}
