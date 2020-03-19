package com.lzhlyle.leetcode.recite.lcof40;

import java.util.PriorityQueue;
import java.util.Queue;

public class ZuiXiaoDeKgeShuLcof_LC_PriorityQueue {
    public int[] getLeastNumbers(int[] arr, int k) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : arr) priorityQueue.add(num);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = priorityQueue.remove();
        return res;
    }
}
