package com.lzhlyle.leetcode.week.lcof40;

import java.util.Arrays;

public class ZuiXiaoDeKgeShuLcof_LC_QuickSort {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        return Arrays.copyOf(arr, k);
    }

    private void quickSort(int[] arr, int l, int r, int k) {
        if (l >= r) return;
        int p = partition(arr, l, r);
        if (p == k) return;
        if (p > k) quickSort(arr, 0, p - 1, k);
        else quickSort(arr, p + 1, r, k);
    }

    private int partition(int[] arr, int l, int r) {
        int pivot = r, counter = l;
        for (int i = l; i < r; i++) {
            if (arr[i] < arr[pivot]) {
                int swap = arr[i];
                arr[i] = arr[counter];
                arr[counter++] = swap;
            }
        }
        int swap = arr[counter];
        arr[counter] = arr[pivot];
        arr[pivot] = swap;
        return counter;
    }
}
