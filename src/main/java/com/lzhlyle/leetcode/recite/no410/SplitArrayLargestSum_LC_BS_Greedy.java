package com.lzhlyle.leetcode.recite.no410;

public class SplitArrayLargestSum_LC_BS_Greedy {
    public int splitArray(int[] nums, int m) {
        // l = 单个最大值, r = 全数组和
        long l = 0, r = 0;
        for (int num : nums) {
            r += num;
            if (num > l) l = num;
        }

        while (l < r) {
            long mid = l + ((r - l) >> 1), sum = 0, cnt = 1;
            for (int num : nums) {
                if (sum + num > mid) {
                    // 新开一组
                    cnt++;
                    sum = num;
                } else sum += num; // 同组累计
            }

            if (cnt > m) l = mid + 1; // 分的组过多，最大值要增大
            else r = mid; // 分的组不够，最大值要减小
        }
        return (int) l;
    }
}
