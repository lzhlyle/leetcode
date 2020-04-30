package com.lzhlyle.leetcode.recite.no703;

import java.util.Arrays;

// O(nklog(k))
public class KthLargestElementInAStream_Sort {
    private int[] arr;
    private int size = 0;

    public void KthLargest(int k, int[] nums) {
        arr = new int[k];
        for (int num : nums) add(num);
    }

    public int add(int val) {
        if (size == arr.length) {
            if (arr[0] < val) arr[0] = val;
        } else arr[size++] = val;
        Arrays.sort(arr, 0, size);
        return arr[0];
    }
}
