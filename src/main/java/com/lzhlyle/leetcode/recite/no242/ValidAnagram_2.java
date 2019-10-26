package com.lzhlyle.leetcode.recite.no242;

import java.util.HashMap;

public class ValidAnagram_2 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        // 哈希表
        HashMap<Character, Integer> map = new HashMap<>();

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        for (char c : sArr) {
            if (map.containsKey(c)) {
                // exist
                map.put(c, map.get(c) + 1);
            } else {
                // first time
                map.put(c, 1);
            }
        }

        for (char c : tArr) {
            if (!map.containsKey(c)) return false;

            Integer times = map.get(c);
            if (times == 1) {
                map.remove(c);
            } else {
                map.put(c, times - 1);
            }
        }

        return map.size() == 0;
    }
}
