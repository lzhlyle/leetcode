package com.lzhlyle.leetcode.self.no42;

import java.util.Stack;

public class TrappingRainWater_Stack {
    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> indexStack = new Stack<>(); // desc
        for (int i = 0; i < height.length; i++) {
            while (!indexStack.isEmpty() && height[i] >= height[indexStack.peek()]) {
                int h = height[indexStack.pop()];
                if (indexStack.isEmpty()) break;
                int width = i - indexStack.peek() - 1;
                int min = Math.min(height[i], height[indexStack.peek()]);
                sum += width * (min - h);
            }
            indexStack.push(i);
        }
        return sum;
    }
}
