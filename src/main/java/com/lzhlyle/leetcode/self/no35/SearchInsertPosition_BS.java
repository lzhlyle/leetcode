package com.lzhlyle.leetcode.self.no35;

public class SearchInsertPosition_BS {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        if (target > nums[r]) return r + 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
