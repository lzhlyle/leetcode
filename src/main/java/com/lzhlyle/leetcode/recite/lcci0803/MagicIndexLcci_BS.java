package com.lzhlyle.leetcode.recite.lcci0803;

public class MagicIndexLcci_BS {
    public int findMagicIndex(int[] nums) {
        if (nums[0] == 0) return 0;
        int l = 0, r = nums.length - 1;
        if (nums[0] > 0) {
            while (l < r) {
                int mid = l + (r - l + 1) / 2;
                if (nums[mid] < mid) r = mid - 1;
                else if (nums[mid] > mid) l++;
                else return mid;
            }
        } else {
            while (l < r) {
                int mid = l + (r - l + 1) / 2;
                if (nums[mid] > mid) r = mid - 1;
                else if (nums[mid] < mid) l++;
                else return mid;
            }
        }
        return -1;
    }
}
