package com.lzhlyle.templates.algorithm.sort;

import java.util.Arrays;

public class HeapSort {
    private static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--) heapify(arr, len, i);

        for (int i = len - 1; i >= 0; i--) {
            int swap = arr[0];
            arr[0] = arr[i];
            arr[i] = swap;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int len, int top) {
        int l = 2 * top + 1, r = l + 1, max = top;
        if (l < len && arr[l] > arr[max]) max = l;
        if (r < len && arr[r] > arr[max]) max = r;
        if (max == top) return;

        int swap = arr[max];
        arr[max] = arr[top];
        arr[top] = swap;
        heapify(arr, len, max);
    }

    public static void main(String[] args) {
        int[] arr = {9, 1, 4, 3, 6, 8, 5, 2, 3, 4, 7, 9, 6, 2, 3, 1, 4, 6, 7, 0, 9, 5};
        HeapSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
