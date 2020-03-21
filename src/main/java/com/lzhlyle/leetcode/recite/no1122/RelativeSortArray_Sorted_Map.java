package com.lzhlyle.leetcode.recite.no1122;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeSortArray_Sorted_Map {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr2) freq.put(num, 0);

        Arrays.sort(arr1);
        int[] res = new int[arr1.length];

        int i = res.length - 1;
        for (int j = arr1.length - 1; j >= 0; j--) {
            int num = arr1[j];
            if (freq.containsKey(num)) freq.put(num, freq.get(num) + 1);
            else res[i--] = num;
        }

        i = 0;
        for (int k : arr2) Arrays.fill(res, i, i += freq.get(k), k);

        return res;
    }
}
