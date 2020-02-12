package com.lzhlyle.leetcode.week.no239;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum_Deque {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return new int[0];
        int[] res = new int[len - k + 1];
        Deque<Integer> deque = new LinkedList<>(); // desc
        for (int i = 0; i < len; i++) {
            int n = nums[i], ri = i - k + 1;
            while (!deque.isEmpty() && deque.getLast() < n) deque.removeLast();
            deque.addLast(n);
            if (ri >= 0) {
                res[ri] = deque.getFirst();
                if (deque.getFirst() == nums[ri]) deque.removeFirst();
            }
        }
        return res;
    }
}
