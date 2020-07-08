package com.lzhlyle.leetcode.tomorrow.no475;

import java.util.Arrays;

public class Heaters_Sort_BS {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int max = 0;
        for (int h : houses) {
            int l = 0, r = heaters.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (heaters[mid] < h) l = mid + 1;
                else r = mid;
            }
            int d0 = l == 0 ? Integer.MAX_VALUE : h - heaters[l - 1];
            int d1 = Math.abs(heaters[l] - h);
            max = Math.max(max, Math.min(d0, d1));
        }
        return max;
    }
}
