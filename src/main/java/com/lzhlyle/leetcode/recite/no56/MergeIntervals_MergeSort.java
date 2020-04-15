package com.lzhlyle.leetcode.recite.no56;

import java.util.Arrays;

public class MergeIntervals_MergeSort {
    // 9ms
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 0) return intervals;

        int[][] res = new int[intervals.length][2];
        mergeSort(intervals, 0, intervals.length - 1);
        res[0] = intervals[0];
        int resIndex = 0, intervalIndex = 1;
        while (intervalIndex < intervals.length) {
            if (res[resIndex][1] >= intervals[intervalIndex][0]) {
                // 区间重叠
                res[resIndex][1] = Math.max(res[resIndex][1], intervals[intervalIndex][1]);
            } else {
                // 无重叠
                resIndex++;
                res[resIndex] = intervals[intervalIndex];
            }
            intervalIndex++;
        }

        int[][] result = new int[resIndex + 1][2];
        System.arraycopy(res, 0, result, 0, resIndex + 1);
        return result;
    }

    // 按左区间升序排列
    private void mergeSort(int[][] arr, int left, int right) {
        if (right <= left) return;

        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[][] arr, int left, int mid, int right) {
        int[][] temp = new int[right - left + 1][2];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = (arr[i][0] < arr[j][0]
                    || (arr[i][0] == arr[j][0] && arr[i][1] < arr[j][1]))
                    ? arr[i++]
                    : arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {2, 3}};
        int[][] res = new MergeIntervals_MergeSort().merge(intervals);
        System.out.println(Arrays.deepToString(res));
    }
}
