package com.lzhlyle.leetcode.recite.no347;

import java.util.*;

public class TopKFrequentElements_Sort {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        for (int v : nums) {
            if (!numFreq.containsKey(v)) numFreq.put(v, 0);
            int freq = numFreq.get(v) + 1;
            numFreq.put(v, freq);
        }

        int n = nums.length, i = 0;
        int[][] arr = new int[n][2]; // {num, freq}
        for (int num : numFreq.keySet()) {
            arr[i][0] = num;
            arr[i][1] = numFreq.get(num);
            i++;
        }

        int[] res = new int[k];

        // O(nlog(n))
//        Arrays.sort(arr, (a, b) -> b[1] - a[1]);
//        for (int ri = 0; ri < k; ri++)
//            res[ri] = arr[ri][0];

        // O(nlog(k))
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int[] a : arr) {
            queue.add(a);
            while (queue.size() > k)
                queue.remove();
        }
        int ri = 0;
        while (!queue.isEmpty())
            res[ri++] = queue.remove()[0];

        return res;
    }
}
