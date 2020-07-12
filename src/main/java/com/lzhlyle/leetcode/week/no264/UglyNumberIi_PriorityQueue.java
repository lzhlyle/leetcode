package com.lzhlyle.leetcode.week.no264;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class UglyNumberIi_PriorityQueue {
    public int nthUglyNumber(int n) {
        Queue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        Set<Long> set = new HashSet<>();
        set.add(1L);
        for (int i = 2; i <= n; i++) {
            long peek = queue.remove();
            if (set.add(peek * 2)) queue.add(peek * 2);
            if (set.add(peek * 3)) queue.add(peek * 3);
            if (set.add(peek * 5)) queue.add(peek * 5);
        }
        return (int) queue.remove().longValue();
    }
}
