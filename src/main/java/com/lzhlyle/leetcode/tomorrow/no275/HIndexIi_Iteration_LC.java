package com.lzhlyle.leetcode.tomorrow.no275;

public class HIndexIi_Iteration_LC {
    public int hIndex(int[] citations) {
        for (int i = 0, n = citations.length; i < n; i++)
            if (citations[i] >= n - i)
                return n - i;
        return 0;
    }
}
