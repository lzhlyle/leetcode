package com.lzhlyle.leetcode.recite.no365;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WaterAndJugProblem_DFS_Recursion {
    private Map<Integer, Set<Integer>> map = new HashMap<>();

    public boolean canMeasureWater(int x, int y, int z) {
        return dfs(0, 0, x, y, z);
    }

    private boolean dfs(int i, int j, int x, int y, int z) {
        if (i + j == z) return true;
        if (map.containsKey(i) && map.get(i).contains(j)) return false;
        if (!map.containsKey(i)) map.put(i, new HashSet<>());
        map.get(i).add(j);

        // +x
        if (dfs(x, j, x, y, z)) return true;

        // +y
        if (dfs(i, y, x, y, z)) return true;

        // -x
        if (dfs(0, j, x, y, z)) return true;

        // -y
        if (dfs(i, 0, x, y, z)) return true;

        // x->y
        if (y - j > i) {
            if (dfs(0, i + j, x, y, z)) return true;
        } else {
            if (dfs(i - (y - j), y, x, y, z)) return true;
        }

        // x<-y
        if (x - i > j) {
            if (dfs(i + j, 0, x, y, z)) return true;
        } else {
            if (dfs(x, j - (x - i), x, y, z)) return true;
        }

        return false;
    }
}
