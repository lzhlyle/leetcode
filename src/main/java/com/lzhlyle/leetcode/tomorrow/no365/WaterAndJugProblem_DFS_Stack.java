package com.lzhlyle.leetcode.tomorrow.no365;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class WaterAndJugProblem_DFS_Stack {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        Set<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int total = stack.pop();
            if (total + x <= x + y && set.add(total + x)) stack.push(total + x);
            if (total + y <= x + y && set.add(total + y)) stack.push(total + y);
            if (total - x >= 0 && set.add(total - x)) stack.push(total - x);
            if (total - y >= 0 && set.add(total - y)) stack.push(total - y);
            if (set.contains(z)) return true;
        }
        return false;
    }
}
