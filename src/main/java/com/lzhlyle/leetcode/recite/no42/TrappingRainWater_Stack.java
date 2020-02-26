package com.lzhlyle.leetcode.recite.no42;

import java.util.Stack;

public class TrappingRainWater_Stack {
    public int trap(int[] height) {
        int len = height.length, sum = 0;
        Stack<Integer> indexStack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!indexStack.isEmpty() && height[i] > height[indexStack.peek()]) {
                int h = height[indexStack.pop()];
                if (indexStack.isEmpty()) break;
                int width = i - indexStack.peek() - 1;
                int min = Math.min(height[indexStack.peek()], height[i]);
                sum += width * (min - h);
            }
            indexStack.push(i);
        }
        return sum;
    }
}
