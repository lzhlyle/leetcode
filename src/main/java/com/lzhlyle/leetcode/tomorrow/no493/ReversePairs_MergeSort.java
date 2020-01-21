package com.lzhlyle.leetcode.tomorrow.no493;

import java.util.Arrays;

public class ReversePairs_MergeSort {
    private int count = 0;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int length = nums.length;
        _sort(nums, Arrays.copyOf(nums, length), 0, length - 1);
        return count;
    }

    private void _sort(int[] src, int[] dest, int start, int end) {
        if (start >= end) return;
        int mid = start + ((end - start) >> 1);
        _sort(dest, src, start, mid);
        _sort(dest, src, mid + 1, end);
        _merge(src, dest, start, mid, end);
    }

    private void _merge(int[] src, int[] dest, int start, int mid, int end) {
        int left = start, right = mid + 1;
        // count
        while (left <= mid && right <= end) {
            if (src[left] > 2 * (long) src[right]) {
                count += mid - left + 1;
                right++;
            } else left++;
        }

        // reverse and merge
        left = start;
        right = mid + 1;
        int i = start;
        while (left <= mid && right <= end) {
            dest[i++] = src[left] < src[right] ? src[left++] : src[right++];
        }
        while (left <= mid) dest[i++] = src[left++];
        while (right <= end) dest[i++] = src[right++];
    }
}
