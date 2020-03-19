package com.lzhlyle.leetcode.week.no33;

public class SearchInRotatedSortedArray_LC_Recite_Left {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[l] < nums[mid]) { // [l, mid] asc
                if (nums[l] <= target && target <= nums[mid]) r = mid;
                else l = mid + 1;
            } else { // [mid+1, r] asc
                if (nums[mid + 1] <= target && target <= nums[r]) l = mid + 1;
                else r = mid;
            }
        }
        return nums[l] == target ? l : -1;
    }
}
