package com.lzhlyle.leetcode.recite.no912;

public class SortAnArray_HeapSort_Recite {
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    private void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int len = arr.length;
        for (int i = len - 1; i >= 0; i--) heapify(arr, len, i);
        for (int i = len - 1; i >= 0; i--) {
            int swap = arr[0];
            arr[0] = arr[i];
            arr[i] = swap;
            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int len, int top) {
        int l = 2 * top + 1, r = l + 1, max = top;
        if (l < len && arr[l] > arr[max]) max = l;
        if (r < len && arr[r] > arr[max]) max = r;
        if (max == top) return;
        int swap = arr[max];
        arr[max] = arr[top];
        arr[top] = swap;
        heapify(arr, len, max);
    }
}
