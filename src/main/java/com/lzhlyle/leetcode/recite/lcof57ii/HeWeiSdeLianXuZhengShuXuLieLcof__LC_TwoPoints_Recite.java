package com.lzhlyle.leetcode.recite.lcof57ii;

import java.util.ArrayList;
import java.util.List;

public class HeWeiSdeLianXuZhengShuXuLieLcof__LC_TwoPoints_Recite {
    public int[][] findContinuousSequence(int target) {
        int l = 1, r = 2, sum = l + r, max = (target >>> 1) + 2;
        List<int[]> list = new ArrayList<>();
        while (l < r && r < max) {
            if (sum < target) sum += ++r;
            else if (sum > target) sum -= l++;
            else {
                int[] arr = new int[r - l + 1];
                int i = 0, j = l;
                while (i < r - l + 1) arr[i++] = j++;
                list.add(arr);
                sum -= l++;
            }
        }
        int[][] res = new int[list.size()][];
        return list.toArray(res);
    }
}
