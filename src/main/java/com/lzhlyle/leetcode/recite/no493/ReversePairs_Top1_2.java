package com.lzhlyle.leetcode.recite.no493;

import java.util.Arrays;

public class ReversePairs_Top1_2 {
    private int count = 0;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int length = nums.length;
        sort(nums, Arrays.copyOf(nums, length), 0, length - 1);
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
            if (src[left] > 2 * (long) src[right]) {
                count += mid - left + 1;
                right++;
            } else left++;
        }

        // merge
        left = start;
        right = mid + 1;
        int d = start;
        while (left <= mid && right <= end) {
            dest[d++] = src[left] < src[right] ? src[left++] : src[right++];
        }
        while (left <= mid) dest[d++] = src[left++];
        while (right <= end) dest[d++] = src[right++];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 3, 5, 1};
        int res = new ReversePairs_Top1_2().reversePairs(nums);
        System.out.println(res);
    }
}
