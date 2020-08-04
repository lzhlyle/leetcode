package com.lzhlyle.leetcode.week.no128;

import java.util.Arrays;

public class LongestConsecutiveSequence_Sort {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int max = 1, curr = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[0]) continue;
            if (nums[i] == nums[0] + 1) curr++;
            else {
                max = Math.max(max, curr);
                curr = 1;
            }
        }
        max = Math.max(max, curr);
        return max;
    }
}
