package com.lzhlyle.leetcode.tomorrow.no75;

public class SortColors_ThreePoints {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1, p = l;
        while (p <= r) {
            if (nums[p] == 0) swap(nums, p++, l++);
            else if (nums[p] == 2) swap(nums, p, r--);
            else p++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }
}
