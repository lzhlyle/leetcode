package com.lzhlyle.leetcode.recite.no239;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum_Deque {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return new int[0];
        int[] res = new int[len - k + 1];
        Deque<Integer> deque = new LinkedList<>(); // desc
        for (int i = 0; i < len; i++) {
            int n = nums[i];
            // 不符合的向后退出，以保证单调递减，以确保first最大
            while (!deque.isEmpty() && deque.getLast() < n) deque.removeLast();
            deque.addLast(n);
            if (i - k + 1 >= 0) {
                // 开始记录最大值
                res[i - k + 1] = deque.getFirst();
                // 滑窗扫过，向前退出
                if (deque.getFirst() == nums[i - k + 1]) deque.removeFirst();
            }
        }
        return res;
    }
}
