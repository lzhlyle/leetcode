package com.lzhlyle.leetcode.tomorrow.no169;

public class MajorityElement_Count {
    public int majorityElement(int[] nums) {
        int res = nums[0], count = 1;
        for (int i = 1; i <= nums.length; i++) {
            if (count == 0) {
                count++;
                res = nums[i];
            } else if (res == nums[i]) count++;
            else count--;
        }
        return res;
    }
}
