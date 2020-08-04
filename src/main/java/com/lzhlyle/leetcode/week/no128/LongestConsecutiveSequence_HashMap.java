package com.lzhlyle.leetcode.week.no128;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence_HashMap {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>(); // (i, r)
        for (int v : nums) map.put(v, v);

        int max = 1;
        for (int v : nums) {
            int r = v;
            while (map.containsKey(r + 1)) r = map.get(r + 1);
            map.put(v, r);
            max = Math.max(max, r - v + 1);
        }
        return max;
    }
}
