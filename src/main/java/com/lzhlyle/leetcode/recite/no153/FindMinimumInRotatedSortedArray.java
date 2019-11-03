package com.lzhlyle.leetcode.recite.no153;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        // base condition
        if (nums == null || nums.length < 1) return -1;
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) return nums[0];

        // binary search
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            // drill down
            // > <
            // < >
            // < <

            if (right - left == 1) return Math.min(nums[left], nums[right]);

            if (nums[left] > nums[mid] && nums[mid] < nums[right]) {
                // should be in left area
                right = mid;
            } else if (nums[left] < nums[mid] && nums[mid] > nums[right]) {
                left = mid;
            } else if (nums[left] < nums[mid] && nums[mid] < nums[right]) {
                return nums[left];
            } else {
                return -1;
            }
        }
        return -1;
    }
}
