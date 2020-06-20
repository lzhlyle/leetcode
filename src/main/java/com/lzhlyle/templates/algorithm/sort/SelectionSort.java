package com.lzhlyle.templates.algorithm.sort;

import java.util.Arrays;

public class SelectionSort {
    // O(n^2)
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // look up the min's index
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            // swap
            int swap = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = swap;
        }
    }
}
