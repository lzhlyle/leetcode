package com.lzhlyle.leetcode.tomorrow.no215;

import java.util.Arrays;

public class KthLargestElementInAnArray_Sort {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
