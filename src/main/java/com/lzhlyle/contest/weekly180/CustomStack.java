package com.lzhlyle.contest.weekly180;

import java.util.Stack;

public class CustomStack {
    Stack<Integer> data, temp;
    int size;

    public CustomStack(int maxSize) {
        data = new Stack<>();
        temp = new Stack<>();
        size = maxSize;
    }

    public void push(int x) {
        if (data.size() == size) return;
        data.push(x);
    }

    public int pop() {
        if (data.isEmpty()) return -1;
        return data.pop();
    }

    public void increment(int k, int val) {
        while (!data.isEmpty()) temp.push(data.pop());
        while (!temp.isEmpty()) {
            if (k-- > 0) data.push(temp.pop() + val);
            else data.push(temp.pop());
        }
    }

    public static void main(String[] args) {
        CustomStack contest = new CustomStack(10);
        {

        }
    }
}
