package com.lzhlyle.leetcode.recite.no1122;

public class RelativeSortArray_LC_CountingSort {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];
        for (int num : arr1) freq[num]++;

        int[] res = new int[arr1.length];
        int i = 0;
        for (int num : arr2) {
            while (freq[num]-- > 0) res[i++] = num;
        }

        for (int num = 0; num < 1001; num++) {
            while (freq[num]-- > 0) res[i++] = num;
        }
        return res;
    }
}
