package com.lzhlyle.leetcode.self.no215;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray_MinHeap {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int v : nums) {
            queue.add(v);
            if (queue.size() > k) queue.remove();
        }
        return queue.remove();
    }
}
