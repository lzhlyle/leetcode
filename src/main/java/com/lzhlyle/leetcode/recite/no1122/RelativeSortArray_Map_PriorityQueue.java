package com.lzhlyle.leetcode.recite.no1122;

import java.util.*;

public class RelativeSortArray_Map_PriorityQueue {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> freq = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : arr2) freq.put(num, 0);
        for (int num : arr1) {
            if (!freq.containsKey(num)) queue.add(num);
            else freq.put(num, freq.get(num) + 1);
        }
        int[] res = new int[arr1.length];
        int i = 0;
        for (int k : arr2) Arrays.fill(res, i, i += freq.get(k), k);
        while (!queue.isEmpty()) res[i++] = queue.remove();
        return res;
    }
}
