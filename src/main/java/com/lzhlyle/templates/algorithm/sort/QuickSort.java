package com.lzhlyle.templates.algorithm.sort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int begin, int end) {
        if (end <= begin) return;

        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = end;
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                int swap = arr[counter];
                arr[counter] = arr[i];
                arr[i] = swap;
                counter++;
            }
        }
        int swap = arr[pivot];
        arr[pivot] = arr[counter];
        arr[counter] = swap;
        return counter;
    }
}
