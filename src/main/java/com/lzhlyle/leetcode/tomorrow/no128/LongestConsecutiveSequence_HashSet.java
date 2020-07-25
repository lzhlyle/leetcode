package com.lzhlyle.leetcode.tomorrow.no128;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence_HashSet {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        int n = nums.length, max = 1;
        Set<Integer> set = new HashSet<>();
        for (int v : nums) set.add(v);

        for (int v : nums) {
            if (set.contains(v - 1)) continue;

            int r = v;
            while (set.contains(r + 1)) r++;
            max = Math.max(max, r - v + 1);
        }
        return max;
    }
}
