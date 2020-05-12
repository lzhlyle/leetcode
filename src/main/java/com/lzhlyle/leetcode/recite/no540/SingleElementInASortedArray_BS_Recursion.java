package com.lzhlyle.leetcode.recite.no540;

public class SingleElementInASortedArray_BS_Recursion {
    public int singleNonDuplicate(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    // T(n) = T(n/2) + O(1)
    private int find(int[] nums, int l, int r) {
        if (l == r) return nums[l];
        int mid = l + (r - l) / 2;
        if (nums[mid] == nums[mid + 1]) {
            int rCnt = r - mid - 1;
            if ((rCnt & 1) == 1) return find(nums, mid + 2, r);
            else return find(nums, l, mid - 1);
        } else if (mid - 1 >= l && nums[mid] == nums[mid - 1]) {
            int lCnt = mid - 1 - l;
            if ((lCnt & 1) == 1) return find(nums, l, mid - 2);
            else return find(nums, mid + 1, r);
        } else return nums[mid];
    }
}
