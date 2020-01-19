package com.lzhlyle.leetcode.recite.no493;

import java.util.Arrays;

public class ReversePairs_Top1 {
    private int count;

    public int reversePairs(int[] nums) {
        int len = nums.length;
        sort(nums, Arrays.copyOf(nums, len), 0, len - 1);
        return count;
    }

    private void sort(int[] src, int[] dest, int start, int end) {
        if (start >= end) return;
        int mid = start + ((end - start) >> 1);
        sort(dest, src, start, mid);
        sort(dest, src, mid + 1, end);
        merge(src, dest, start, mid, end);
    }

    private void merge(int[] src, int[] dest, int start, int mid, int end) {
        int left = start, right = mid + 1;

        // count
        while (left <= mid && right <= end) {
            if (src[left] > 2 * ((long) src[right])) {
                count += mid - left + 1;
                right++;
            } else left++;
        }

        // reverse left and right, for merging
        left = start;
        right = mid + 1;
        int k = start;
        while (left <= mid && right <= end) {
            dest[k++] = src[left] <= src[right] ? src[left++] : src[right++];
        }
        while (left <= mid) dest[k++] = src[left++];
        while (right <= end) dest[k++] = src[right++];
    }
}
