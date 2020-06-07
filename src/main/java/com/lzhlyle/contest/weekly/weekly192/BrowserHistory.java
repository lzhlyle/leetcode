package com.lzhlyle.contest.weekly.weekly192;

import java.util.Stack;

public class BrowserHistory {
    Stack<String> a, b;

    public BrowserHistory(String homepage) {
        a = new Stack<>();
        a.push(homepage);
        b = new Stack<>();
    }

    public void visit(String url) {
        b.clear();
        a.push(url);
    }

    public String back(int steps) {
        while (steps-- > 0 && a.size() > 1) {
            b.push(a.pop());
        }
        return a.peek();
    }

    public String forward(int steps) {
        while (steps-- > 0 && !b.isEmpty()) {
            a.push(b.pop());
        }
        return a.peek();
    }

    public static void main(String[] args) {
        BrowserHistory contest = new BrowserHistory("");
        {

        }
    }
}
