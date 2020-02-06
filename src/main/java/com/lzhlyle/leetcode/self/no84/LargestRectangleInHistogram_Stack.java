package com.lzhlyle.leetcode.self.no84;

import java.util.Stack;

public class LargestRectangleInHistogram_Stack {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>(); // asc
        stack.push(-1);
        int max = 0, len = heights.length;
        for (int i = 0; i < len; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) max = Math.max(max, heights[stack.pop()] * (len - stack.peek() - 1));
        return max;
    }
}
