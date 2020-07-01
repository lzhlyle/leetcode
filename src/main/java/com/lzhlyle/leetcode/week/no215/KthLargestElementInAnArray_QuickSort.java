package com.lzhlyle.leetcode.week.no215;

import java.util.Random;

public class KthLargestElementInAnArray_QuickSort {
    private Random rd = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k, nums.length);
    }

    private int quickSort(int[] nums, int l, int r, int k, int n) {
        if (l >= r) return nums[l];
        int p = partition(nums, l, r);
        if (k == n - p) return nums[p];
        if (k > n - p) return quickSort(nums, l, p - 1, k, n);
        return quickSort(nums, p + 1, r, k, n);
    }

    private int partition(int[] nums, int l, int r) {
        int ri = rd.nextInt(r - l + 1) + l;
        swap(nums, ri, r);

        int p = r, c = l;
        for (int i = l; i <= r; i++)
            if (nums[i] < nums[p])
                swap(nums, i, c++);
        swap(nums, p, c);
        return c;
    }

    private void swap(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }
}
