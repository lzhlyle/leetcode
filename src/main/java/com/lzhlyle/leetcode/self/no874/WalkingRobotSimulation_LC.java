package com.lzhlyle.leetcode.self.no874;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WalkingRobotSimulation_LC {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1, 0}; // north -> west -> south -> east
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] obstacle : obstacles) {
            if (!map.containsKey(obstacle[0])) map.put(obstacle[0], new HashSet<>());
            map.get(obstacle[0]).add(obstacle[1]);
        }

        int i = 0, j = 0, di = 0, max = 0;
        for (int cmd : commands) {
            if (cmd == -2) di = (di + 1) % 4;
            else if (cmd == -1) di = (di + 3) % 4;
            else {
                for (int step = 0; step < cmd; step++) {
                    int x = i + dx[di], y = j + dy[di];
                    if (map.containsKey(x) && map.get(x).contains(y)) break;
                    i = x;
                    j = y;
                }
                max = Math.max(max, i * i + j * j);
            }
        }
        return max;
    }
}
