package com.lzhlyle.leetcode.recite.no155;

import java.util.Stack;

public class MinStack {
    Stack<Integer> normal, min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        normal = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        normal.push(x);
        if (min.isEmpty() || min.peek() > x) min.push(x);
        else min.push(min.peek());
    }

    public void pop() {
        normal.pop();
        min.pop();
    }

    public int top() {
        return normal.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
