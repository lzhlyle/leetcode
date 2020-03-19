package com.lzhlyle.leetcode.week.no1013;

public class PartitionArrayIntoThreePartsWithEqualSum_TwoPoints {
    public boolean canThreePartsEqualSum(int[] nums) {
        int len = nums.length, l = 0, r = len - 1, sum = 0;
        for (int num : nums) sum += num;
        if (sum % 3 != 0) return false;
        int avg = sum / 3, suml = nums[l], sumr = nums[r];
        while (l + 1 < r) {
            if (suml == avg && sumr == avg) return true;
            if (suml != avg) suml += nums[++l];
            if (sumr != avg) sumr += nums[--r];
        }
        return false;
    }
}
