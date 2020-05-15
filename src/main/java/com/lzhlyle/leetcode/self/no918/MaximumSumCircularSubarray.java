package com.lzhlyle.leetcode.self.no918;

public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] A) {
        int max = A[0], currMax = 0;
        for (int v : A) {
            currMax = Math.max(currMax + v, v);
            max = Math.max(max, currMax);
        }
        if (A.length < 3) return max;

        int sum = 0;
        for (int v : A) sum += v;

        int min = A[1], currMin = 0;
        for (int i = 1; i < A.length - 1; i++) {
            int v = A[i];
            currMin = Math.min(currMin + v, v);
            min = Math.min(min, currMin);
        }

        return Math.max(max, sum - min);
    }
}
