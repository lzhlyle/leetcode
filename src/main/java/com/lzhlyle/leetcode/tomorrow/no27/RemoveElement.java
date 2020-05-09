package com.lzhlyle.leetcode.tomorrow.no27;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int n : nums) {
            if (n != val) nums[i++] = n;
        }
        return i;
    }
}
