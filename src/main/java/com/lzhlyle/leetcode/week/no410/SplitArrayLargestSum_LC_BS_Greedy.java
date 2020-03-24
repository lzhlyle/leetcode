package com.lzhlyle.leetcode.week.no410;

public class SplitArrayLargestSum_LC_BS_Greedy {
    public int splitArray(int[] nums, int m) {
        int max = 0, sum = 0;
        for (int num : nums) {
            if (num > max) max = num;
            sum += num;
        }

        int l = max, r = sum;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            int cnt = 1, curr = 0;
            for (int num : nums) {
                if (curr + num > mid) {
                    curr = num;
                    cnt++;
                } else curr += num;
            }

            if (cnt > m) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
