package com.lzhlyle.leetcode.recite.no205;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings_Map_Set {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.isEmpty()) return true;
        Map<Character, Character> from = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char schar = s.charAt(i), tchar = t.charAt(i);
            if (from.containsKey(schar) && from.get(schar) != tchar) return false;
            if (!from.containsKey(schar) && set.contains(tchar)) return false;
            if (!from.containsKey(schar) && !set.contains(tchar)) {
                from.put(schar, tchar);
                set.add(tchar);
            }
        }
        return true;
    }
}
