package com.lzhlyle.leetcode.self.no1013;

public class PartitionArrayIntoThreePartsWithEqualSum_TwoPoints {
    public boolean canThreePartsEqualSum(int[] nums) {
        int len = nums.length, l = 0, r = len - 1, sumL = nums[l], sumR = nums[r], sum = 0, avg = 0;
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
