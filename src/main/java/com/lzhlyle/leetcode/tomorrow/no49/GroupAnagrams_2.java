package com.lzhlyle.leetcode.tomorrow.no49;

import java.util.*;

public class GroupAnagrams_2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length < 1) return Collections.emptyList();
        if (strs.length == 1) return Collections.singletonList(Collections.singletonList(strs[0]));

        // 暴力加速 质数相乘
        Map<Integer, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int key = 1; // for multiplying
            for (char c : str.toCharArray()) {
                key = key * _PRIMES[c - 'a']; // 0-25
            }

            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private static final int[] _PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61,
            67, 71, 73, 79, 83, 89, 97, 101, 107};
}
