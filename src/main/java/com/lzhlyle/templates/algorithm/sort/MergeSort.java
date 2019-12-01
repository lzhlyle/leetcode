package com.lzhlyle.templates.algorithm.sort;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (right <= left) return;

        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 1, 4, 3, 6, 8, 5, 2, 3, 4, 7, 9, 6, 2, 3, 1, 4, 6, 7, 0, 9, 5};
        MergeSort.mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
