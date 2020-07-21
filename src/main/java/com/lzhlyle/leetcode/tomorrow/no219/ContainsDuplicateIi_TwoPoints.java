package com.lzhlyle.leetcode.tomorrow.no219;

public class ContainsDuplicateIi_TwoPoints {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        if (k <= 0 || n < 2) return false;

        int l = 0, r = 1;
        while (r < n) {
            if (l < r && nums[l] == nums[r]) return true;
            if (r - l == k) l++;
            else r++;
        }

        while (l < n - 1)
            if (nums[l++] == nums[n - 1]) return true;

        return false;
    }
}
