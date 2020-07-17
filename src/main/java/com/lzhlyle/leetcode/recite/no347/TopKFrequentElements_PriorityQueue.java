package com.lzhlyle.leetcode.recite.no347;

import java.util.*;

public class TopKFrequentElements_PriorityQueue {
    // O(nlog(k))
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        for (int v : nums) {
            if (!numFreq.containsKey(v)) numFreq.put(v, 0);
            int freq = numFreq.get(v) + 1;
            numFreq.put(v, freq);
        }

        Map<Integer, Set<Integer>> freqNum = new HashMap<>();
        Queue<Integer> freqQueue = new PriorityQueue<>();
        for (Integer v : numFreq.keySet()) {
            Integer f = numFreq.get(v);
            if (!freqNum.containsKey(f)) {
                freqNum.put(f, new HashSet<>());
                freqQueue.add(f);
                while (freqQueue.size() > k)
                    freqQueue.remove();
            }
            freqNum.get(f).add(v);
        }

        Stack<Integer> stack = new Stack<>();
        while (!freqQueue.isEmpty())
            stack.push(freqQueue.remove());

        int[] res = new int[k];
        int i = 0;
        while (!stack.isEmpty() && k > 0) {
            for (int v : freqNum.get(stack.pop())) {
                k--;
                res[i++] = v;
            }
        }
        return res;
    }
}
