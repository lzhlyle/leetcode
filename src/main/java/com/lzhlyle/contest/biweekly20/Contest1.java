package com.lzhlyle.contest.biweekly20;

import java.util.Arrays;

public class Contest1 {
    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr);
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = left + ((right - left) >> 1);

        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            int ci = countOne(arr[i]), cj = countOne(arr[j]);
            temp[k++] = ci <= cj ? arr[i++] : arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }

    private int countOne(int n) {
        int count = 0, t = n;
        while (t != 0) {
            t &= t - 1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {
            int[] arr = new int[]{0, 7, 2, 3, 4, 5, 6, 1, 8};
            contest.sortByBits(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
}
