package com.lzhlyle.templates.algorithm;

import java.util.Arrays;

/**
 * 二分查找
 */
public class BinarySearch {

    public int binarySearch(int[] arr, int target) {
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;

            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
