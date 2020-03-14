package com.lzhlyle.leetcode.recite.no410;

public class SplitArrayLargestSum_LC_BS_Greedy_Recite {
    public int splitArray(int[] nums, int m) {
        long l = 0, r = 0;
        for (int num : nums) {
            r += num;
            if (num > l) l = num;
        }

        while (l < r) {
            long mid = l + ((r - l) >> 1), sum = 0, cnt = 1;
            for (int num : nums) {
                if (sum + num > mid) {
                    ++cnt;
                    sum = num;
                } else sum += num;
            }

            if (cnt > m) l = mid + 1; // 组多值小，应往右
            else r = mid;
        }
        return (int) l;
    }
}
