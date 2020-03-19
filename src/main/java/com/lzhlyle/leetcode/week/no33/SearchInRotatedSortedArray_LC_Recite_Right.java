package com.lzhlyle.leetcode.week.no33;

public class SearchInRotatedSortedArray_LC_Recite_Right {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l + 1) >> 1);
            if (nums[mid] < nums[r]) { // [mid, r] asc
                if (nums[mid] <= target && target <= nums[r]) l = mid;
                else r = mid - 1;
            } else { // [l, mid-1] asc
                if (nums[l] <= target && target <= nums[mid - 1]) r = mid - 1;
                else l = mid;
            }
        }
        return nums[l] == target ? l : -1;
    }
}
