package com.lzhlyle.leetcode.week.no739;

import java.util.Stack;

public class DailyTemperatures_Stack {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        if (n < 2) return new int[n];

        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>(); // index: desc
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int j = stack.pop();
                res[j] = i - j;
            }
            stack.push(i);
        }
        return res;
    }
}
