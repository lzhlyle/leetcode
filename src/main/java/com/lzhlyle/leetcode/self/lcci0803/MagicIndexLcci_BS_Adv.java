package com.lzhlyle.leetcode.self.lcci0803;

public class MagicIndexLcci_BS_Adv {
    public int findMagicIndex(int[] nums) {
        if (nums[0] == 0) return 0;
        int l = 0, r = nums.length - 1;
        boolean b = nums[0] > 0;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (b ? nums[mid] < mid : nums[mid] > mid)
                r = mid - 1;
            else l++;
        }
        return nums[l] == l ? l : -1;
    }
}
