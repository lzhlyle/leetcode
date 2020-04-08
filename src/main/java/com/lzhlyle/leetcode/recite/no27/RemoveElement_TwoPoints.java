package com.lzhlyle.leetcode.recite.no27;

public class RemoveElement_TwoPoints {
    // not good
    public int removeElement(int[] nums, int val) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] == val) nums[l] = nums[r--];
            else l++;
        }
        return l;
    }
}
