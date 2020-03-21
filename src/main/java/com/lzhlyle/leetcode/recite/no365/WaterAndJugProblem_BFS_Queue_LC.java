package com.lzhlyle.leetcode.recite.no365;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WaterAndJugProblem_BFS_Queue_LC {
    public boolean canMeasureWater(int x, int y, int z) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int total = queue.poll();

            // +x
            if (total + x <= x + y && set.add(total + x)) {
                queue.add(total + x);
            }

            // +y
            if (total + y <= x + y && set.add(total + y)) {
                queue.add(total + y);
            }

            // -x
            if (total - x >= 0 && set.add(total - x)) {
                queue.add(total - x);
            }

            // -y
            if (total - y >= 0 && set.add(total - y)) {
                queue.add(total - y);
            }

            if (set.contains(z)) return true;
        }
        return false;
    }
}
