package com.lzhlyle.leetcode.self.no16;

import java.util.Arrays;

public class Solution3sumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE, res = target;
        for (int i = 0, n = nums.length; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) return sum;

                int delta = Math.abs(sum - target);
                if (delta < min) {
                    min = delta;
                    res = sum;
                }

                if (sum < target) l++;
                else r--;
            }
        }
        return res;
    }
}
