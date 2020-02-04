package com.lzhlyle.leetcode.self.no239;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum_Deque {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return new int[0];
        int[] res = new int[len - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            int n = nums[i];
            while (!deque.isEmpty() && deque.getLast() < n) deque.removeLast();
            deque.addLast(n);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = deque.getFirst();
                if (deque.getFirst() == nums[i - k + 1]) deque.removeFirst();
            }
        }
        return res;
    }
}
