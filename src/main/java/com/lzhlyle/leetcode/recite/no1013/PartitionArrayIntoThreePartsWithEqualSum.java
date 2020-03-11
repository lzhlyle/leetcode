package com.lzhlyle.leetcode.recite.no1013;

public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] nums) {
        int l = 0, r = nums.length - 1, sumL = 0, sumR = 0, sum = 0;
        for (int n : nums) sum += n;
        while (l + 1 < r) {
            sumL += nums[l];
            sum -= nums[l++];
            if (sumL * 2 == sum) {
                while (l < r) {
                    sumR += nums[r];
                    sum -= nums[r--];
                    if (sumR == sum) return true;
                }
                return false;
            }
        }
        return false;
    }
}
