package com.lzhlyle.leetcode.week.no475;

import java.util.Arrays;

public class Heaters_SortBoth {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int max = 0, i = 0, n = heaters.length;
        for (int h : houses) {
            // look up first larger
            while (i < n && heaters[i] <= h) i++;
            int d0 = i == 0 ? Integer.MAX_VALUE : h - heaters[i - 1];
            int d1 = i == n ? Integer.MAX_VALUE : heaters[i] - h;
            max = Math.max(max, Math.min(d0, d1));
        }
        return max;
    }
}
