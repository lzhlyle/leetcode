package com.lzhlyle.leetcode.tomorrow.no918;

public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] A) {
        int max = A[0], currMax = 0, sum = 0;
        for (int a : A) {
            sum += a;
            if (currMax > 0) currMax += a;
            else currMax = a;
            if (currMax > max) max = currMax;
        }
        if (A.length < 3) return max;

        int min = A[0], currMin = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (currMin < 0) currMin += A[i];
            else currMin = A[i];
            if (currMin < min) min = currMin;
        }
        return Math.max(max, sum - min);
    }
}
