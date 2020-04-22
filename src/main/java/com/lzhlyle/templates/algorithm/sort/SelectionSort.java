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

//    public static void main(String[] args) {
//        int[] arr = {1, 4, 3, 6, 8, 5, 2, 3, 4, 7, 9, 6, 2, 3, 1, 4, 6, 7, 0};
//        SelectionSort.selectionSort(arr);
//        System.out.println(Arrays.toString(arr));
//    }
}
