package com.lzhlyle.leetcode.recite.no49;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length < 1) return null;
        if (strs.length == 1) {
            return Collections.singletonList(Collections.singletonList(strs[0]));
        }

        // 暴力解
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);

            if (map.containsKey(sortedStr)) {
                // exist
                map.get(sortedStr).add(str);
            } else {
                // first time
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedStr, list);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (String sortedSort : map.keySet()) {
            res.add(map.get(sortedSort));
        }
        return res;
    }
}
