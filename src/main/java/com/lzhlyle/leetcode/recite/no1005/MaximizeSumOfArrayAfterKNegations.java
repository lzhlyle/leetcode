package com.lzhlyle.leetcode.recite.no1005;

import java.util.Arrays;

public class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] arr, int k) {
        Arrays.sort(arr); // 负数...0...0..正数
        int sum = 0, len = arr.length, minIndex = 0;
        while (k > 0) {
            arr[minIndex] = -arr[minIndex];
            k--;
            if (minIndex + 1 < len && arr[minIndex] > arr[minIndex + 1]) minIndex++;
        }
        for (int i : arr) sum += i;
        return sum;
    }
}
