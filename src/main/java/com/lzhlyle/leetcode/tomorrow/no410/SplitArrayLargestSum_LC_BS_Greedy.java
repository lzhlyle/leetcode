package com.lzhlyle.leetcode.tomorrow.no410;

public class SplitArrayLargestSum_LC_BS_Greedy {
    public int splitArray(int[] nums, int m) {
        int l = 0, r = 0;
        for (int num : nums) {
            r += num;
            if (num > l) l = num;
        }

        while (l < r) {
            int mid = l + ((r - l) >> 1), cnt = 1, sum = 0;
            for (int num : nums) {
                if (sum + num > mid) {
                    sum = num;
                    cnt++;
                } else sum += num;
            }

            if (cnt > m) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
