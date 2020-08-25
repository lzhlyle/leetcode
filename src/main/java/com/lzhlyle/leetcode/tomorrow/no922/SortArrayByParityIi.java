package com.lzhlyle.leetcode.tomorrow.no922;

public class SortArrayByParityIi {
    public int[] sortArrayByParityII(int[] arr) {
        for (int i = 0, j = 1; i < arr.length && j < arr.length; i += 2, j += 2) {
            while (i < arr.length && (arr[i] & 1) == 0) i += 2;
            while (j < arr.length && (arr[j] & 1) == 1) j += 2;
            if (i < arr.length && j < arr.length) {
                int swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;
            }
        }
        return arr;
    }
}
