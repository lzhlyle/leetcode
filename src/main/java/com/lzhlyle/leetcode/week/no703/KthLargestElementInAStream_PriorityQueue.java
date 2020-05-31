package com.lzhlyle.leetcode.tomorrow.no703;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAStream_PriorityQueue {
    // O(nlog(k))
    private Queue<Integer> queue;
    private int capacity;

    public void KthLargest(int k, int[] nums) {
        capacity = k;
        queue = new PriorityQueue<>(); // min heap
        new PriorityQueue<>(k);
        for (int num : nums) add(num);
    }

    // O(log(k))
    public int add(int val) {
        if (queue.size() < capacity) queue.add(val);
        else if (queue.element() < val) {
            queue.remove();
            queue.add(val);
        }
        return queue.element();
    }
}
