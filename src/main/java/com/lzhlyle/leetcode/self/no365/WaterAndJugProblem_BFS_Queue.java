package com.lzhlyle.leetcode.self.no365;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WaterAndJugProblem_BFS_Queue {
    public boolean canMeasureWater(int x, int y, int z) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int curr = queue.remove();
            if (curr + x <= x + y && set.add(curr + x)) queue.add(curr + x);
            if (curr + y <= x + y && set.add(curr + y)) queue.add(curr + y);
            if (curr - x >= 0 && set.add(curr - x)) queue.add(curr - x);
            if (curr - y >= 0 && set.add(curr - y)) queue.add(curr - y);
            if (set.contains(z)) return true;
        }
        return false;
    }
}
