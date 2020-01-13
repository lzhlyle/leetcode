package com.lzhlyle.leetcode.tomorrow.no242;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagramNew_2 {
    // hash map
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        for (int i = 0; i < sChar.length; i++) {
            map.put(sChar[i], map.getOrDefault(sChar[i], 0) + 1);
            map.put(tChar[i], map.getOrDefault(tChar[i], 0) - 1);
        }
        for (Character key : map.keySet()) if (map.get(key) != 0) return false;
        return true;
    }
}
