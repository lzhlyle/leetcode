package com.lzhlyle.leetcode.self.no365;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class WaterAndJugProblem_DFS_Stack {
    public boolean canMeasureWater(int x, int y, int z) {
        Set<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (curr + x <= x + y && set.add(curr + x)) stack.push(curr + x);
            if (curr + y <= x + y && set.add(curr + y)) stack.push(curr + y);
            if (curr - x >= 0 && set.add(curr - x)) stack.push(curr - x);
            if (curr - y >= 0 && set.add(curr - y)) stack.push(curr - y);
            if (set.contains(z)) return true;
        }
        return false;
    }
}
