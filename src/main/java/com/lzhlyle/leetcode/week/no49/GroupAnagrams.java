package com.lzhlyle.leetcode.week.no49;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length < 1) return Collections.emptyList();
        if (strs.length == 1) return Collections.singletonList(Collections.singletonList(strs[0]));

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedStr = String.valueOf(arr);
            if (!map.containsKey(sortedStr)) map.put(sortedStr, new LinkedList<>());
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
