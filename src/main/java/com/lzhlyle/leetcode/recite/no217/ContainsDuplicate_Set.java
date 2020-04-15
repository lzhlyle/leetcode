package com.lzhlyle.leetcode.recite.no217;

import java.util.Arrays;

public class ContainsDuplicate_Set {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }
}
