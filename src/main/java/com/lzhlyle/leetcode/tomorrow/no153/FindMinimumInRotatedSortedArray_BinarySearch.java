package com.lzhlyle.leetcode.tomorrow.no153;

public class FindMinimumInRotatedSortedArray_BinarySearch {
    public int findMin(int[] nums) {
        if (nums == null || nums.length < 1) return -1;
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) return nums[0];

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < nums[right]) right = mid;
            else left = mid + 1;
        }
        return nums[left];
    }
}
