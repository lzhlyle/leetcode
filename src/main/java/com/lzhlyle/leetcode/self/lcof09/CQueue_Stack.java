package com.lzhlyle.leetcode.self.lcof09;

import java.util.Stack;

public class CQueue_Stack {
    private Stack<Integer> in, out;

    public CQueue_Stack() {
        in = new Stack<Integer>();
        out = new Stack<Integer>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (!out.isEmpty()) return out.pop();
        while (!in.isEmpty())
            out.push(in.pop());
        if (out.isEmpty()) return -1;
        return out.pop();
    }
}
