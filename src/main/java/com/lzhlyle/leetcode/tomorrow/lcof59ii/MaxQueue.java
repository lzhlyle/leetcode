package com.lzhlyle.leetcode.tomorrow.lcof59ii;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class MaxQueue {
    Queue<Integer> data;
    Deque<Integer> max; // desc

    public MaxQueue() {
        data = new ArrayDeque<>();
        max = new ArrayDeque<>();
    }

    public int max_value() {
        if (max.isEmpty()) return -1;
        return max.getFirst();
    }

    public void push_back(int value) {
        data.add(value);
        while (!max.isEmpty() && value > max.getLast()) max.removeLast();
        max.addLast(value);
    }

    public int pop_front() {
        if (data.isEmpty()) return -1;
        if (max.getFirst().equals(data.element())) max.removeFirst();
        return data.remove();
    }
}