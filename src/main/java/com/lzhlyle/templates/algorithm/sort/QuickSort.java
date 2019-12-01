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
        System.out.println(Arrays.toString(arr));
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                int swap = arr[counter];
                arr[counter] = arr[i];
                arr[i] = swap;
                counter++;
                System.out.println(Arrays.toString(arr));
            }
        }
        int swap = arr[pivot];
        arr[pivot] = arr[counter];
        arr[counter] = swap;
        System.out.println(Arrays.toString(arr));
        System.out.println();
        return counter;
    }

    public static void main(String[] args) {
        int[] arr = {9, 1, 4, 3, 6, 8, 5, 2, 3, 4, 7, 9, 6, 2, 3, 1, 4, 6, 7, 0, 9, 5};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
