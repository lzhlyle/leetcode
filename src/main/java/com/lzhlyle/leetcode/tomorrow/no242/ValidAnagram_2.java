package com.lzhlyle.leetcode.tomorrow.no242;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_2 {
    public boolean isAnagram(String s, String t) {
        // base condition
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        // 哈希表
        Map<Character, Integer> mapCharTimes = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            if (mapCharTimes.containsKey(sChar)) mapCharTimes.put(sChar, mapCharTimes.get(sChar) + 1);
            else mapCharTimes.put(sChar, 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char tChar = t.charAt(i);
            Integer times = mapCharTimes.get(tChar);
            if (times == null) return false;
            else if (times == 1) mapCharTimes.remove(tChar);
            else mapCharTimes.put(tChar, times - 1);
        }

        return mapCharTimes.isEmpty();
    }
}
