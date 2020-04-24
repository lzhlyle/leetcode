package com.lzhlyle.leetcode.week.no493;

public class ReversePairs_MergeSort {
    // merget sort
    private int cnt = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return cnt;
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private void merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (arr[i] > 2 * (long) arr[j]) {
                cnt += mid - i + 1;
                j++;
            } else i++;
        }

        i = l;
        j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];
        System.arraycopy(temp, 0, arr, l, r - l + 1);
    }

    public static void main(String[] args) {
        int res = new ReversePairs_MergeSort().reversePairs(new int[]{1, 3, 2, 3, 1, 3, 4, 2});
        System.out.println(res);
    }
}
