package com.lzhlyle.leetcode.tomorrow.no49;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams_3 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length < 1) return Collections.emptyList();
        if (strs.length == 1) return Collections.singletonList(Collections.singletonList(strs[0]));

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);

            if (!map.containsKey(sortedStr)) map.put(sortedStr, new LinkedList<>());
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
