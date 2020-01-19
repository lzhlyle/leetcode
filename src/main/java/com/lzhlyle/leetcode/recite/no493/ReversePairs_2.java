package com.lzhlyle.leetcode.recite.no493;

public class ReversePairs_2 {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;

        int mid = left + ((right - left) >> 1);
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

        int[] cache = new int[right - left + 1];
        int leftIndex = left, copyIndex = left, cacheIndex = 0;
        for (int rightIndex = mid + 1; rightIndex <= right; rightIndex++, cacheIndex++) {
            // look up the middle value in the right array
            while (leftIndex <= mid && nums[leftIndex] <= 2 * (long) nums[rightIndex]) leftIndex++;

            // merge
            while (copyIndex <= mid && nums[copyIndex] < nums[rightIndex]) cache[cacheIndex++] = nums[copyIndex++];
            cache[cacheIndex] = nums[rightIndex];

            count += mid - leftIndex + 1;
        }
        while (copyIndex <= mid) cache[cacheIndex++] = nums[copyIndex++];
        System.arraycopy(cache, 0, nums, left, right - left + 1);
        return count;
    }
}
