package com.lzhlyle.leetcode.recite.no169;

public class MajorityElement_Count_II {
    public int majorityElement(int[] nums) {
        int res = 0, count = 0;
        for (int n : nums) {
            if (count == 0) res = n;
            count += res == n ? 1 : -1;
        }
        return res;
    }
}
