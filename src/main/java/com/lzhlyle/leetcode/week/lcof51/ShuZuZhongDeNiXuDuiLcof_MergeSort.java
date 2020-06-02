package com.lzhlyle.leetcode.week.lcof51;

public class ShuZuZhongDeNiXuDuiLcof_MergeSort {
    // merge sort O(nlog(n))
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] arr, int l, int r) {
        if (l >= r) return 0;
        int mid = l + ((r - l) >> 1), cnt;
        cnt = mergeSort(arr, l, mid);
        cnt += mergeSort(arr, mid + 1, r);
        return cnt + merge(arr, l, mid, r);
    }

    private int merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0, cnt = 0;
        while (i <= mid && j <= r) {
            if (arr[i] > arr[j]) {
                cnt += mid - i + 1;
                temp[k++] = arr[j++];
            } else temp[k++] = arr[i++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];
        System.arraycopy(temp, 0, arr, l, r - l + 1);
        return cnt;
    }
}
