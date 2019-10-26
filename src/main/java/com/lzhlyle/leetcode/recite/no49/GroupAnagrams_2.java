package com.lzhlyle.leetcode.recite.no49;

import java.util.*;

public class GroupAnagrams_2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length < 1) return null;
        if (strs.length == 1) {
            return Collections.singletonList(Collections.singletonList(strs[0]));
        }

        // 暴力加速
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String uniqueStr = _generateUniqueStr(str);

            if (map.containsKey(uniqueStr)) {
                // exist
                map.get(uniqueStr).add(str);
            } else {
                // first time
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(uniqueStr, list);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (String sortedSort : map.keySet()) {
            res.add(map.get(sortedSort));
        }
        return res;
    }

    private String _generateUniqueStr(String str) {
        char[] arr = str.toCharArray();
        int[] uniqueArr = new int['z' - 'a' + 1];
        for (char c : arr) {
            uniqueArr[c - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int count : uniqueArr) {
            builder.append("#").append(count);
        }
        return builder.toString();
    }

//    public static void main(String[] args) {
//        System.out.println(new GroupAnagrams_2()._generateUniqueStr("helloworld"));
//    }
}
