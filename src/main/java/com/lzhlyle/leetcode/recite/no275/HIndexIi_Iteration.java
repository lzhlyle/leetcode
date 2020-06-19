package com.lzhlyle.leetcode.recite.no275;

public class HIndexIi_Iteration {
    public int hIndex(int[] citations) {
        int n = citations.length, max = 0;
        for (int i = n - 1; i >= 0; i--) {
            int min = Math.min(n - i, citations[i]);
            max = Math.max(max, min);
        }
        return max;
    }
}
