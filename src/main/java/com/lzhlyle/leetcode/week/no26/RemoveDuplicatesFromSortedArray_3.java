package com.lzhlyle.leetcode.week.no26;

public class RemoveDuplicatesFromSortedArray_3 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;

        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast - 1] != nums[fast]) nums[slow++] = nums[fast];
        }

        return slow;
    }
}
