package com.lzhlyle.leetcode.week.no403;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump_LC_Map {
    // stone, last-step
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;
        int len = stones.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (i > 3 && stones[i] >= 2 * stones[i - 1]) return false;
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(0);
        for (int stone : stones) {
            for (Integer k : map.get(stone)) {
                for (int far = k + 1; far > k - 2; far--) {
                    if (far > 0 && map.containsKey(stone + far)) {
                        map.get(stone + far).add(far);
                    }
                }
            }
        }
        return map.get(stones[len - 1]).size() > 0;
    }
}
