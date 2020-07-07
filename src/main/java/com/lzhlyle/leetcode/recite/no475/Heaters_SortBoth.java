package com.lzhlyle.leetcode.recite.no475;

import java.util.Arrays;

public class Heaters_SortBoth {
    public int findRadius(int[] houses, int[] heaters) {
        int n = heaters.length;

        Arrays.sort(houses);
        Arrays.sort(heaters);

        int i = 0, max = 0;
        for (int h : houses) {
            while (i < n && heaters[i] <= h) i++;
            int d0 = i == 0 ? Integer.MAX_VALUE : h - heaters[i - 1];
            int d1 = i == n ? Integer.MAX_VALUE : heaters[i] - h;
            max = Math.max(max, Math.min(d0, d1));
        }
        return max;
    }
}
