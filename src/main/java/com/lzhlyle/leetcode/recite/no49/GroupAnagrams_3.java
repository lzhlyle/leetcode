package com.lzhlyle.leetcode.recite.no49;

import java.util.*;

public class GroupAnagrams_3 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length < 1) return null;
        if (strs.length == 1) {
            return Collections.singletonList(Collections.singletonList(strs[0]));
        }

        // 暴力加速
        Map<Integer, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Integer uniqueNum = _generateUniqueStr(str);

            if (map.containsKey(uniqueNum)) {
                // exist
                map.get(uniqueNum).add(str);
            } else {
                // first time
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(uniqueNum, list);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (Integer uni : map.keySet()) {
            res.add(map.get(uni));
        }
        return res;
    }

    private static final int[] PRIMES = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61,
            67, 71, 73, 79, 83, 89, 97, 101, 107};

    private Integer _generateUniqueStr(String str) {
        char[] arr = str.toCharArray();
        int res = 1;
        for (char c : arr) {
            res = res * PRIMES[c - 'a'];
        }
        return res;
    }

//    public static void main(String[] args) {
//        System.out.println(new GroupAnagrams_2()._generateUniqueStr("helloworld"));
//    }
}
