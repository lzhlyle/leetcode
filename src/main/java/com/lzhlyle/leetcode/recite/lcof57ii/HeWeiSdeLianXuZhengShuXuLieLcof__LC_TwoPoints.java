package com.lzhlyle.leetcode.recite.lcof57ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeWeiSdeLianXuZhengShuXuLieLcof__LC_TwoPoints {
    public int[][] findContinuousSequence(int target) {
        int l = 1, r = 2, sum = l + r, max = (target >>> 1) + 2;
        List<int[]> list = new ArrayList<>();
        while (l < r && r < max) {
            if (sum < target) sum += ++r;
            else if (sum > target) sum -= l++;
            else {
                int[] sub = new int[r - l + 1];
                int i = 0, j = l;
                while (i < r - l + 1) sub[i++] = j++;
                list.add(sub);
                sum -= l++;
            }
        }
        int[][] out = new int[list.size()][];
        return list.toArray(out);
    }

    public static void main(String[] args) {
        int[][] res = new HeWeiSdeLianXuZhengShuXuLieLcof__LC_TwoPoints().findContinuousSequence(9);
        for (int[] ints : res) System.out.println(Arrays.toString(ints));
    }
}
