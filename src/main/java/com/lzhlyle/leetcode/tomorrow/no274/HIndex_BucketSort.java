package com.lzhlyle.leetcode.tomorrow.no274;

public class HIndex_BucketSort {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] bucket = new int[n + 1];
        for (int c : citations)
            bucket[Math.min(c, n)]++;
        for (int i = n, sum = 0; i >= 0; i--)
            if ((sum += bucket[i]) >= i)
                return i;
        return 0;
    }
}
