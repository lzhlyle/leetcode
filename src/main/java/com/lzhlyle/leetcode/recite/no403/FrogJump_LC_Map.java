package com.lzhlyle.leetcode.recite.no403;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump_LC_Map {
    public boolean canCross(int[] stones) {
        int len = stones.length;
        Map<Integer, Set<Integer>> map = new HashMap<>(); // stone, steps
        for (int stone : stones) map.put(stone, new HashSet<>());
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            if (i > 3 && stones[i] >= 2 * stones[i - 1]) return false;
            int stone = stones[i];
            for (Integer k : map.get(stone)) {
                for (int step = k + 1; step > k - 2; step--) {
                    if (step > 0 && map.containsKey(stone + step)) {
                        map.get(stone + step).add(step);
                    }
                }
            }
        }
        return map.get(stones[len - 1]).size() > 0;
    }
}
