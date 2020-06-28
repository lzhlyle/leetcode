package com.lzhlyle.contest.weekly.weekly195;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Contest1 {
    public boolean isPathCrossing(String path) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        map.put(0, new HashSet<>());
        map.get(0).add(0);
        int x = 0, y = 0;
        for (char c : path.toCharArray()) {
            if (c == 'N') y++;
            else if (c == 'S') y--;
            else if (c == 'E') x++;
            else if (c == 'W') x--;

            if (map.containsKey(x) && map.get(x).contains(y)) return true;
            if (!map.containsKey(x)) map.put(x, new HashSet<>());
            map.get(x).add(y);
        }
        return false;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {

        }
    }
}
