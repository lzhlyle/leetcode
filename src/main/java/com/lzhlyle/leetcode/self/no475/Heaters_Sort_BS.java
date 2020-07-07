package com.lzhlyle.leetcode.self.no475;

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
            int minDis = Math.min(l == 0 ? Integer.MAX_VALUE : h - heaters[l - 1],
                    Math.abs(heaters[l] - h));
            max = Math.max(max, minDis);
        }
        return max;
    }
}
