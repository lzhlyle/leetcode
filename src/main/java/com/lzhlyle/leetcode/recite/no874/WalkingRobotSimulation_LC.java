package com.lzhlyle.leetcode.recite.no874;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WalkingRobotSimulation_LC {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // north -> east -> south -> west
        int x = 0, y = 0, di = 0, max = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] obstacle : obstacles) {
            if (!map.containsKey(obstacle[0])) map.put(obstacle[0], new HashSet<>());
            map.get(obstacle[0]).add(obstacle[1]);
        }

        for (int cmd : commands) {
            // north -> east -> south -> west
            if (cmd == -1) di = (di + 1) % 4;
            else if (cmd == -2) di = (di + 3) % 4;
            else {
                for (int step = 0; step < cmd; step++) {
                    int nx = x + dir[di][0];
                    int ny = y + dir[di][1];
                    if (map.containsKey(nx) && map.get(nx).contains(ny)) break;
                    x = nx;
                    y = ny;
                }
                max = Math.max(max, x * x + y * y);
            }
        }
        return max;
    }
}
