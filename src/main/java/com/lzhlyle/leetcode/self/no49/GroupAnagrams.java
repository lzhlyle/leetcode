package com.lzhlyle.leetcode.self.no49;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length < 1) return null;
        if (strs.length == 1) return Collections.singletonList(Collections.singletonList(strs[0]));

        // 暴力解
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String uniqKey = _generateUniqKeyForAnagram(str);
            if (!map.containsKey(uniqKey))  {
                map.put(uniqKey, new ArrayList<>());
            }
            map.get(uniqKey).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private String _generateUniqKeyForAnagram(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
}
