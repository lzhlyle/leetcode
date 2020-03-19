package com.lzhlyle.leetcode.recite.lcof40;

import java.util.Arrays;

public class ZuiXiaoDeKgeShuLcof_LC_QuickSort {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        return Arrays.copyOfRange(arr, 0, k);
    }

    private void quickSort(int[] arr, int begin, int end, int k) {
        if (end <= begin) return;
        int pivot = partition(arr, begin, end);
        if (pivot == k) return;
        if (pivot > k) quickSort(arr, begin, pivot - 1, k);
        else quickSort(arr, pivot + 1, end, k);
    }

    private int partition(int[] arr, int begin, int end) {
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                int swap = arr[counter];
                arr[counter++] = arr[i];
                arr[i] = swap;
            }
        }
        int swap = arr[pivot];
        arr[pivot] = arr[counter];
        arr[counter] = swap;
        return counter;
    }
}
