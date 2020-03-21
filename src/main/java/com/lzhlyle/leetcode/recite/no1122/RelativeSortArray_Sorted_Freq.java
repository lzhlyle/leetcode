package com.lzhlyle.leetcode.recite.no1122;

import java.util.Arrays;

public class RelativeSortArray_Sorted_Freq {
    private int _BASE = 10; // should larger than 0

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];
        for (int num : arr2) freq[num] = _BASE; // base

        Arrays.sort(arr1);
        int[] res = new int[arr1.length];

        int i = res.length - 1;
        for (int j = arr1.length - 1; j >= 0; j--) {
            int num = arr1[j];
            if (freq[num] >= _BASE) freq[num]++;
            else res[i--] = num;
        }

        i = 0;
        for (int num : arr2) Arrays.fill(res, i, i += freq[num] - _BASE, num);

        return res;
    }
}
