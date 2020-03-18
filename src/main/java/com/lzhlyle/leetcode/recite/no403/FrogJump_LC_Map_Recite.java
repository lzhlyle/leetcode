package com.lzhlyle.leetcode.recite.no403;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump_LC_Map_Recite {
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;
        int len = stones.length;
        Map<Integer, Set<Integer>> map = new HashMap<>(); // stone, last-steps
        for (int stone : stones) map.put(stone, new HashSet<>());
        map.get(0).add(0);
        for (int i = 0; i < len; i++) {
            if (i > 3 && stones[i] >= 2 * stones[i - 1]) return false;
            for (Integer jump : map.get(stones[i])) {
                for (int k = jump + 1; k > jump - 2; k--) {
                    if (k > 0 && map.containsKey(stones[i] + k)) {
                        map.get(stones[i] + k).add(k);
                    }
                }
            }
        }
        return map.get(stones[len - 1]).size() > 0;
    }
}
