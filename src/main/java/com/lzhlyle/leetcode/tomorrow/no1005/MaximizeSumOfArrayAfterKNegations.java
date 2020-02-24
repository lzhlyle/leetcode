package com.lzhlyle.leetcode.tomorrow.no1005;

import java.util.Arrays;

public class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] arr, int k) {
        Arrays.sort(arr); // asc

        int minIndex = 0;
        while (k-- > 0) {
            arr[minIndex] = -arr[minIndex];
            if (minIndex + 1 < arr.length && arr[minIndex] > arr[minIndex + 1]) minIndex++;
        }

        int sum = 0;
        for (int i : arr) sum += i;
        return sum;
    }
}
