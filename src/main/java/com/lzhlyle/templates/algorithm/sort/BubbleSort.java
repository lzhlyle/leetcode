package com.lzhlyle.templates.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                }
            }
        }
    }

//    public static void main(String[] args) {
//        int[] arr = {9, 1, 4, 3, 6, 8, 5, 2, 3, 4, 7, 9, 6, 2, 3, 1, 4, 6, 7, 0, 9, 1};
//        BubbleSort.bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
//    }
}
