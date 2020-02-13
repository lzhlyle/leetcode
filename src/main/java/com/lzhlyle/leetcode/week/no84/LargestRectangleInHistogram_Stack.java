package com.lzhlyle.leetcode.week.no84;

import java.util.Stack;

public class LargestRectangleInHistogram_Stack {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> indexes = new Stack<>(); // asc
        indexes.push(-1);
        int max = 0, len = heights.length;
        for (int i = 0; i < len; i++) {
            while (indexes.peek() != -1 && heights[indexes.peek()] > heights[i]) {
                max = Math.max(max, heights[indexes.pop()] * (i - indexes.peek() - 1));
            }
            indexes.push(i);
        }
        while (indexes.peek() != -1) max = Math.max(max, heights[indexes.pop()] * (len - indexes.peek() - 1));
        return max;
    }
}
