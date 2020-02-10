package com.lzhlyle.leetcode.week.no493;

import java.util.Arrays;

public class ReversePairs {
    private int count = 0;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int len = nums.length;
        _sort(nums, Arrays.copyOf(nums, len), 0, len - 1);
        return count;
    }

    private void _sort(int[] src, int[] dest, int begin, int end) {
        if (begin >= end) return;
        int mid = begin + ((end - begin) >> 1);
        _sort(dest, src, begin, mid);
        _sort(dest, src, mid + 1, end);
        _merge(src, dest, begin, mid, end);
    }

    private void _merge(int[] src, int[] dest, int begin, int mid, int end) {
        int left = begin, right = mid + 1;

        // count
        while (left <= mid && right <= end) {
            if (src[left] > 2 * (long) src[right]) {
                count += mid - left + 1;
                right++;
            } else left++;
        }

        // reverse and merge
        left = begin;
        right = mid + 1;
        int d = begin;
        while (left <= mid && right <= end) {
            dest[d++] = src[left] < src[right] ? src[left++] : src[right++];
        }
        while (left <= mid) dest[d++] = src[left++];
        while (right <= end) dest[d++] = src[right++];
    }

    public static void main(String[] args) {
        int res = new ReversePairs().reversePairs(new int[]{1, 3, 2, 3, 1, 3, 4, 2});
        System.out.println(res);
    }
}
