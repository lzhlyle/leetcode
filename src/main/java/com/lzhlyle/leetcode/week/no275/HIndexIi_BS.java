package com.lzhlyle.leetcode.week.no275;

public class HIndexIi_BS {
    // binary search
    public int hIndex(int[] citations) {
        int n = citations.length, l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (citations[mid] < n - mid) l = mid + 1;
            else r = mid;
        }
        return n - l;
    }
}
