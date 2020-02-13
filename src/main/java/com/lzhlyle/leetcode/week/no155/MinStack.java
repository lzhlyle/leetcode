package com.lzhlyle.leetcode.week.no155;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> data, min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (!min.isEmpty() && min.peek() < x) min.push(min.peek());
        else min.push(x);
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
