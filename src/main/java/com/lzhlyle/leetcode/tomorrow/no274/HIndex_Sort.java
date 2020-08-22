package com.lzhlyle.leetcode.tomorrow.no274;

import java.util.Arrays;

public class HIndex_Sort {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length, l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (citations[mid] < n - mid) l = mid + 1;
            else r = mid;
        }
        return n - l;
    }
}
