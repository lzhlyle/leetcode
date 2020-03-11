package com.lzhlyle.leetcode.recite.no874;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WalkingRobotSimulation {
    // wrong
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            if (!map.containsKey(obstacle[0])) map.put(obstacle[0], new HashSet<>());
            map.get(obstacle[0]).add(obstacle[1]);
            set.add(obstacle[0] + "," + obstacle[1]);
        }

        int x = 0, y = 0, di = 0, max = 0;
        for (int cmd : commands) {
            if (cmd == -2) di = (di + 1) % 4;
            else if (cmd == -1) di = (di + 3) % 4;
            else {
                for (int step = 0; step < cmd; step++) {
                    int nx = x + dx[di], ny = y + dy[di];
                    if (set.contains(nx + "," + ny)) break;
                    //                    if (map.containsKey(nx) && map.get(nx).contains(ny)) break;
                    x = nx;
                    y = nx;
                    max = Math.max(max, x * x + y * y);
                }
            }
        }
        return max;
    }
}
