package com.lzhlyle.leetcode.week.lcof59ii;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {

    private Queue<Integer> data;
    private Deque<Integer> max; // desc

    public MaxQueue() {
        data = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        if (data.isEmpty()) return -1;
        return max.getFirst();
    }

    public void push_back(int value) {
        data.add(value);
        while (!max.isEmpty() && value > max.getLast()) max.removeLast();
        max.addLast(value);
    }

    public int pop_front() {
        if (data.isEmpty()) return -1;
        if (data.element().equals(max.getFirst())) max.removeFirst();
        return data.remove();
    }
}