package com.lzhlyle.leetcode.tomorrow.no169;

public class MajorityElement_Count_II {
    public int majorityElement(int[] nums) {
        int res = 0, count = 0;
        for (int n : nums) {
            res = count == 0 ? n : res;
            count += res == n ? 1 : -1;
        }
        return res;
    }
}
