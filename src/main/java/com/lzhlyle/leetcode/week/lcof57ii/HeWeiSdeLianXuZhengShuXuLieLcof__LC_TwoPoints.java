package com.lzhlyle.leetcode.week.lcof57ii;

import java.util.ArrayList;
import java.util.List;

public class HeWeiSdeLianXuZhengShuXuLieLcof__LC_TwoPoints {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int l = 1, r = 2, sum = l + r, max = (target >> 1) + 2;
        while (l < r && r < max) {
            if (sum < target) sum += ++r;
            else if (sum > target) sum -= l++;
            else {
                int[] arr = new int[r - l + 1];
                for (int i = l; i < r + 1; ++i) arr[i - l] = i;
                list.add(arr);
                sum -= l++;
            }
        }
        int[][] res = new int[list.size()][];
        return list.toArray(res);
    }
}
