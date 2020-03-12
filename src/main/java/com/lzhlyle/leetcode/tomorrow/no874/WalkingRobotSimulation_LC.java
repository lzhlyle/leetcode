package com.lzhlyle.leetcode.tomorrow.no874;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WalkingRobotSimulation_LC {
    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] ob : obstacles) {
            if (!map.containsKey(ob[0])) map.put(ob[0], new HashSet<>());
            map.get(ob[0]).add(ob[1]);
        }
        int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1, 0};
        int di = 0, max = 0, i = 0, j = 0;
        for (int cmd : commands) {
            if (cmd == -2) di = (di + 1) % 4;
            else if (cmd == -1) di = (di + 3) % 4;
            else {
                while (cmd-- > 0) {
                    int expi = i + dx[di], expj = j + dy[di];
                    if (map.containsKey(expi) && map.get(expi).contains(expj)) break;
                    i = expi;
                    j = expj;
                }
                max = Math.max(max, i * i + j * j);
            }
        }
        return max;
    }
}
