package com.lzhlyle.leetcode.recite.no1013;

public class PartitionArrayIntoThreePartsWithEqualSum_TwoPoints {
    public boolean canThreePartsEqualSum(int[] nums) {
        int l = 0, r = nums.length - 1, sumL = nums[0], sumR = nums[nums.length - 1], sum = 0, avg;
        for (int n : nums) sum += n;
        if (sum % 3 != 0) return false;
        avg = sum / 3;
        while (l + 1 < r) {
            if (sumL == avg && sumR == avg) return true;
            if (sumL != avg) sumL += nums[++l];
            if (sumR != avg) sumR += nums[--r];
        }
        return false;
    }
}
