package com.lzhlyle.leetcode.self.no347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements_BucketSort {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        for (int v : nums) {
            if (!numFreq.containsKey(v)) numFreq.put(v, 0);
            int freq = numFreq.get(v) + 1;
            numFreq.put(v, freq);
        }

        int n = nums.length;
        List<Integer>[] bucket = new List[n + 1];
        for (Integer num : numFreq.keySet()) {
            int f = numFreq.get(num);
            if (bucket[f] == null) bucket[f] = new ArrayList<>();
            bucket[f].add(num);
        }

        int[] res = new int[k];
        for (int f = n, ri = 0; f >= 0 && k > 0; f--) {
            if (bucket[f] != null) {
                for (int num : bucket[f]) {
                    res[ri++] = num;
                    k--;
                }
            }
        }
        return res;
    }
}
