package com.lzhlyle.leetcode.tomorrow.no49;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length < 1) return Collections.emptyList();
        if (strs.length == 1) return Collections.singletonList(Collections.singletonList(strs[0]));

        // 暴力解：哈希 排序 比较
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);

            if (map.containsKey(key)) map.get(key).add(str);
            else map.put(key, new ArrayList<>(Collections.singleton(str)));
        }
        return new ArrayList<>(map.values());
    }
}
