package com.lzhlyle.leetcode.tomorrow.no1013;

public class PartitionArrayIntoThreePartsWithEqualSum_TwoPoints {
    public boolean canThreePartsEqualSum(int[] nums) {
        int len = nums.length, sum = 0, avg, l = 0, r = len - 1, suml = nums[l], sumr = nums[r];
        for (int n : nums) sum += n;
        if (sum % 3 != 0) return false;
        avg = sum / 3;
        while (l + 1 < r) {
            if (suml == avg && sumr == avg) return true;
            if (suml != avg) suml += nums[++l];
            if (sumr != avg) sumr += nums[--r];
        }
        return false;
    }
}
