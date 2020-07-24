package com.lzhlyle.leetcode.recite.no128;

import java.util.Arrays;

public class LongestConsecutiveSequence_Sort {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int max = 1, curr = 1, last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == last) continue;
            if (nums[i] == last + 1) curr++;
            else {
                max = Math.max(max, curr);
                curr = 1;
            }
            last = nums[i];
        }
        max = Math.max(max, curr);
        return max;
    }
}
