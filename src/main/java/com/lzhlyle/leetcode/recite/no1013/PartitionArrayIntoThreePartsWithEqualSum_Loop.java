package com.lzhlyle.leetcode.recite.no1013;

public class PartitionArrayIntoThreePartsWithEqualSum_Loop {
    public boolean canThreePartsEqualSum(int[] nums) {
        int sum = 0, part = 0, cnt = 0;
        for (int n : nums) sum += n;
        if (sum % 3 != 0) return false;
        int average = sum / 3;
        for (int n : nums) {
            part += n;
            if (part != average) continue; // not the average.
            ++cnt; // find an average, increase the counter.
            part = 0; // reset part.
        }
        return cnt >= 3;
    }
}
