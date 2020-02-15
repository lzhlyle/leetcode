package com.lzhlyle.leetcode.week.no169;

public class MajorityElement_Count_II {
    public int majorityElement(int[] nums) {
        int res = 0, count = 0;
        for (int num : nums) {
            res = count == 0 ? num : res;
            count += res == num ? 1 : -1;
        }
        return res;
    }
}
