package com.lzhlyle.leetcode.recite.no41;

public class FirstMissingPositive_LC_ArrayHash {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // val should be in (val-1)
            while (nums[i] > 0 && nums[i] - 1 < len && nums[i] != nums[nums[i] - 1]) {
                int swap = nums[i];
                nums[i] = nums[swap - 1];
                nums[swap - 1] = swap;
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return len + 1;
    }
}
