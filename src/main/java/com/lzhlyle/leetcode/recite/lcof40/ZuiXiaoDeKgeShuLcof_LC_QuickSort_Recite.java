package com.lzhlyle.leetcode.recite.lcof40;

import java.util.Arrays;

public class ZuiXiaoDeKgeShuLcof_LC_QuickSort_Recite {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        return Arrays.copyOfRange(arr, 0, k);
    }

    private void quickSort(int[] arr, int l, int r, int k) {
        if (l >= r) return;
        int pivot = partition(arr, l, r);
        if (pivot == k) return;
        if (pivot > k) quickSort(arr, l, pivot - 1, k);
        else quickSort(arr, pivot + 1, r, k);
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
        int swap = arr[pivot];
        arr[pivot] = arr[counter];
        arr[counter] = swap;
        return counter;
    }
}
