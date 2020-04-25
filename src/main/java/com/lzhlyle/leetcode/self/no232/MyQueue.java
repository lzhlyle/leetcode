package com.lzhlyle.leetcode.self.no232;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> input, output;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        input = new Stack<Integer>();
        output = new Stack<Integer>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        input.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (empty()) throw new RuntimeException("empty queue!");
        if (!output.isEmpty()) return output.pop();
        _move();
        return output.pop();
    }

    // return move cnt
    //     -1: cannot move
    private int _move() {
        if (!output.isEmpty()) return -1;
        while (!input.isEmpty()) output.push(input.pop());
        return output.size();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (empty()) throw new RuntimeException("empty queue!");
        if (!output.isEmpty()) return output.peek();
        _move();
        return output.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

}
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
