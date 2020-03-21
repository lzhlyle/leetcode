package com.lzhlyle.leetcode.recite.no1122;

import java.util.Arrays;

public class RelativeSortArray_CountingSort {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freqGiven = new int[1001], freqNon = new int[1001];
        for (int num : arr2) freqGiven[num] = 1; // 与0区分
        for (int num : arr1) {
            if (freqGiven[num] > 0) freqGiven[num]++;
            else freqNon[num]++;
        }

        int[] res = new int[arr1.length];
        int i = 0;
        for (int num : arr2) {
            Arrays.fill(res, i, i += freqGiven[num] - 1, num);
        }
        for (int num = 0; num < freqNon.length; num++) {
            if (freqNon[num] > 0) Arrays.fill(res, i, i += freqNon[num], num);
        }
        return res;
    }
}
