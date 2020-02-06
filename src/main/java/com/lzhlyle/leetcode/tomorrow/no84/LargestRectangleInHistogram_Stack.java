package com.lzhlyle.leetcode.tomorrow.no84;

import java.util.Stack;

public class LargestRectangleInHistogram_Stack {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> indexStack = new Stack<>(); // asc
        indexStack.push(-1);
        int max = 0, len = heights.length;
        for (int i = 0; i < len; i++) {
            while (indexStack.peek() != -1 && heights[indexStack.peek()] > heights[i]) {
                max = Math.max(max, heights[indexStack.pop()] * (i - indexStack.peek() - 1));
            }
            indexStack.push(i);
        }
        while (indexStack.peek() != -1) {
            max = Math.max(max, heights[indexStack.pop()] * (len - indexStack.peek() - 1));
        }
        return max;
    }
}
