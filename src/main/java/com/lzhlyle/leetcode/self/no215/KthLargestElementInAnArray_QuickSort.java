package com.lzhlyle.leetcode.self.no215;

import java.util.Random;

public class KthLargestElementInAnArray_QuickSort {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }

    private int quickSort(int[] arr, int l, int r, int k) {
        if (l >= r) return arr[l];
        int n = arr.length;
        int p = partition(arr, l, r);
        if (k == n - p) return arr[p];
        if (k < n - p) return quickSort(arr, p + 1, r, k);
        return quickSort(arr, l, p - 1, k);
    }

    private int partition(int[] arr, int l, int r) {
        // random swap
        int ri = new Random().nextInt(r - l + 1) + l;
        int rswap = arr[r];
        arr[r] = arr[ri];
        arr[ri] = rswap;

        int p = r, c = l;
        for (int i = l; i < r; i++) {
            if (arr[i] < arr[p]) {
                int swap = arr[i];
                arr[i] = arr[c];
                arr[c++] = swap;
            }
        }
        int swap = arr[p];
        arr[p] = arr[c];
        arr[c] = swap;
        return c;
    }
}
